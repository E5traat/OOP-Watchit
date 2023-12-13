import java.io.*;
import java.util.ArrayList;

public class IOClass {

    public static void OutputData(AdminList a, MovieList m, CastList c, UserList u, DirectorList d) throws IOException {
        File file = new File("adminList.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(a.arrAdmin);
        oos.close();

        file = new File("movieList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(MovieList.arr);
        oos.close();

        file = new File("castList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(CastList.allActors);
        oos.close();

        file = new File("userList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(UserList.arr);
        oos.close();

        file = new File("directorList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(DirectorList.directorsList);
        oos.close();
    }

    public static void InputData(AdminList a, MovieList m, CastList c, UserList u, DirectorList d) throws IOException, ClassNotFoundException {
        File file = new File("adminList.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        a.arrAdmin = (ArrayList<Admin>) ois.readObject();
        ois.close();

        file = new File("movieList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        MovieList.arr = (ArrayList<Movie>) ois.readObject();
        ois.close();

        file = new File("castList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        CastList.allActors = (ArrayList<Cast>) ois.readObject();
        ois.close();

        file = new File("userList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        UserList.arr = (ArrayList<User>) ois.readObject();
        ois.close();

        file = new File("directorList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        DirectorList.directorsList = (ArrayList<Director>) ois.readObject();
        ois.close();
    }
    public static void OutputAdmin(AdminList a) throws IOException {
        File adminList = new File("adminList.txt");
        ObjectOutputStream ooas = new ObjectOutputStream(new FileOutputStream(adminList));
        ooas.writeObject(a);
        ooas.close();


    }

    public static void OutputMovie(ArrayList <Movie> m) throws IOException {
        File movieList = new File("movieList.txt");
        ObjectOutputStream ooms = new ObjectOutputStream(new FileOutputStream(movieList));
        ooms.writeObject(m);
        ooms.close();
    }

    public static AdminList InputAdmin() throws IOException, ClassNotFoundException {
        File adminList = new File("adminList.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(adminList));
        AdminList temp = (AdminList) ois.readObject();
        ois.close();
        return temp;
    }

    public static ArrayList <Movie> InputMovie() throws IOException, ClassNotFoundException {
        File movieList = new File("movieList.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(movieList));
        ArrayList <Movie> temp = (ArrayList <Movie>) ois.readObject();
        ois.close();
        return temp;
    }
}

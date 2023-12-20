import java.io.*;
import java.util.ArrayList;

public class IOClass {

    public static void OutputData(AdminList a) throws IOException {
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

        file = new File("basicList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Basic.arrBasic);
        oos.close();

        file = new File("StandardList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Standard.arrStandard);
        oos.close();

        file = new File("premiumList.txt");
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Premium.arrPremium);
        oos.close();
    }

    public static void InputData(AdminList a) throws IOException, ClassNotFoundException {
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

        file = new File("basicList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        Basic.arrBasic = (ArrayList<Subscription>) ois.readObject();
        ois.close();

        file = new File("standardList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        Standard.arrStandard = (ArrayList<Subscription>) ois.readObject();
        ois.close();

        file = new File("premiumList.txt");
        ois = new ObjectInputStream(new FileInputStream(file));
        Premium.arrPremium = (ArrayList<Subscription>) ois.readObject();
        ois.close();
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class DirectorList {
    public static ArrayList<Director> directorsList = new ArrayList<>();
    Scanner input = new Scanner (System.in);


    public void newDirector()
    {
        System.out.println("fulfill the director details");
        System.out.println();
        System.out.println("enter first name");
        String firstName=input.next();
        System.out.println("enter last name");
        String lastName = input.next();
        System.out.println("enter gender");
        String gender = input.next();
        System.out.println("enter nationality");
        String nationality =input.next();
        System.out.println("enter age");
        int age = input.nextInt();
        Director m=new Director(firstName,lastName,gender ,nationality,age);
        addDirector (m);
    }

    public void addDirector(Director m)
    {
        directorsList.add(m);
    }
    public void deleteDirector(int index)
    {
        directorsList.remove(directorsList.get(index-1));
    }

    /*public static ArrayList<Director> getArr() {
        return directorsList;
    }*/

    public void setArr(ArrayList<Director> arr) {
        this.directorsList = arr;
    }
    public void displayAllDirectors()
    {
        System.out.println ("\t\t\t\t Directors List");
        if(directorsList.isEmpty()) {
            System.out.println ("\t\t\t\tthere is no directors right now");
        }
        else {
            for (int i = 0; i < directorsList.size (); i++) {
                System.out.println ("[" + (i + 1) + "] " + directorsList.get (i).getFirstName ()+" "+directorsList.get (i).getLastName ());
            }
        }
    }

    public void displayListDirectors()
    {
        for (Director director : directorsList) {
            System.out.println(director.toString());
        }
    }

    public void directorMenu(){
        System.out.println ("\t\tplease select one of the operations below");
        System.out.println ();
        System.out.println ("[1] Add Director");
        System.out.println ("[2] Update Director");
        System.out.println ("[3] Remove Director");
        System.out.println ("[4] Show Director Details");
        System.out.println ("[5] back");
    }
    public  void updateDirectorsMenu(int index)
    {
        System.out.println ("\t\twelcome to director update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] First Name\t\t[2] Last Name");
        System.out.println ();
        System.out.println ("[3] Age\t\t[4] Gender");
        System.out.println ();
        System.out.println ("[5] Nationality\t\t[6] Back");
        System.out.println ();
        int choice =input.nextInt ();
        if(choice==6)
            return;
        else
            this.updateDirector (index ,choice);
    }
    public void updateDirector(int index, int choice){

        if(choice==1) {
            String s =input.next();
            directorsList.get(index-1).setFirstName(s);
        }

        else if(choice==2) {
            String s =input.next();
            directorsList.get(index-1).setLastName (s);
        }

        else if(choice==3) {
            String s =input.next();
            directorsList.get(index-1).setAge (Integer.parseInt(s) );
        }

        else if(choice==4) {
            String s =input.next();
            directorsList.get(index-1).setGender(s);
        }
        else if(choice==5)
        {
            String s =input.next();
            directorsList.get(index-1).setNationality(s);
        }

    }
    public void showDirectorDetails(int index)
    {
        displayDirectorDetails (directorsList.get(index - 1) );

    }

    public void displayDirectorDetails(Director director) {
        System.out.println("First Name : " + director.firstName);
        System.out.println("Last Name : " + director.lastName);
        System.out.println("Age :" + director.age);
        System.out.println("Gender : " + director.gender);
        System.out.println("Nationality : " + director.nationality);
        System.out.println("Movies : ");
        ArrayList <Movie> directorMovies= director.getMovies();
        if(directorMovies.isEmpty()){
            System.out.println("No Movies Assigned");
        }
        else {
            for (int i = 0; i < director.getMovies().size(); i++) {
                System.out.println("[" + (i + 1) + "]" + directorMovies.get(i).getTitle());
            }
        }
    }
}
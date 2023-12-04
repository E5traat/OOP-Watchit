import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    Scanner input = new Scanner (System.in);
    public static ArrayList<User> arr = new ArrayList<User>();

    public int addUser(User u, String planInput)
    {
        u.subscription = planInput;
        arr.add(u);
        if (planInput.contains("1")){
            Basic basicPlan = new Basic(u.getID(), "Basic");
            Basic.addSubscription(basicPlan);
        } else if (planInput.contains("2")) {
            Standard standardPlan = new Standard(u.getID(), "Standard");
            Standard.addSubscription(standardPlan);
        } else if (planInput.contains("3")) {
            Premium premiumPlan = new Premium(u.getID(), "Premium");
            Premium.addSubscription(premiumPlan);
        }

        return arr.indexOf(u);

    }


    public void deleteUser(int index)
    {

        if (UserList.arr.get(index).subscription.equals("Basic")) {
            Basic.deleteSubscription(UserList.arr.get(index).getID());
        } else if (UserList.arr.get(index).subscription.equals("Standard")) {
            Standard.deleteSubscription(UserList.arr.get(index).getID());
        } else if (UserList.arr.get(index).subscription.equals("Premium")) {
            Premium.deleteSubscription(UserList.arr.get(index).getID());
        }
        UserWatchRecordList.removeRecords(UserList.arr.get(index).ID);
        arr.remove(index);
    }

    public int userExist(String username , String password)
    {
        for (User user:arr) {
            if(user.getUserName().equals (username) && user.getPassword ().equals (password))
                return arr.indexOf(user);

        }
        return -1;
    }
    public int queryUser()
    {
        System.out.println ("Enter your username :");
        String username = input.next ();
        System.out.println ("Enter your first name :");
        String fName = input.next ();
        System.out.println ("Enter your last name :");
        String lName = input.next();
        System.out.println ("Enter your password : ");
        String pass = input.next ();
        System.out.println ("Enter your Email: ");
        String email = input.next ();
        System.out.println("choose one of the following monthly plans:");
        System.out.println("[1] Basic(5 movies/month)\n[2] Standard(10 movies/month)\t\t[3] Premium(30 movies/month)");
        String planInput = input.next ();
        User u = new User(username ,fName,lName,pass,email);
        int newIndex = addUser(u, planInput);
        return newIndex;
    }


public void mostWatchedMovies(){
    for (Movie movie : MovieList.arr){

    }
}



    public void userMenu(){
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("\t\t[1] watch Movie");
        System.out.println ("\t\t[2] watch Movie later");
        System.out.println ("\t\t[3] show History");
        System.out.println ("\t\t[4] show watch later");
        System.out.println ("\t\t[5] see movie details");
        System.out.println ("\t\t[6] search ");
        System.out.println("\t\t[7] most viewed movies");
        System.out.println("\t\t[8] delete user");
        System.out.println ("\t\t[9] log out ");
        System.out.println();
    }

    public void recursiveSearch(){
        System.out.println("enter the keyword you want to search for:");
        String keyword = input.next().toLowerCase();
        System.out.println("The Results:");
        for (Movie movie : MovieList.arr){
            if (movie.getTitle().toLowerCase().contains(keyword)){
                System.out.println("-"+ movie.getTitle() + " ( movie )");
            }
        }
        for (Cast cast : CastList.allActors){
            if (cast.firstName.toLowerCase().contains(keyword) || cast.firstName.toLowerCase().contains(keyword)){
                System.out.println("-"+ cast.getFirstName() + " " + cast.getLastName() + " ( Actor )");
            }
        }
        for (Director director : DirectorList.directorsList){
            if (director.firstName.toLowerCase().contains(keyword) || director.firstName.toLowerCase().contains(keyword)){
                System.out.println("-"+ director.getFirstName() + " " + director.getLastName() + " ( Actor )");
            }
        }
    }
    public void displayAllUsers(){
        for (User user : arr){
            System.out.println( (arr.indexOf(user) + 1) + ")" + user.firstName + " " + user.lastName);
        }

    }

    public  void updateCastsMenu(int index )
    {
        System.out.println ("\t\twelcome to the profile update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] First name\t\t[2] Last Name");
        System.out.println ();
        System.out.println ("[3] password\t\t[4] email ");
        System.out.println ();
        System.out.println ("[5] Back ");
        int choice = input.nextInt ();
        if(choice==5)
            return;
        else
            this.updateUser (index ,choice);
    }
    public void updateUser(int index, int choice){

        if(choice==1)
        {  String s =input.next();
            arr.get(index-1).setFirstName(s);
        }
        else if(choice==2)
        {
            String s =input.next();
            arr.get(index-1).setLastName (s);
        }
        else if(choice==3)
        {
            String s =input.next();
            arr.get(index-1).setPassword(s);
        }
        else if(choice==4)
        {
            String s =input.next();
            arr.get(index-1).setEmail(s);
        }

    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    Scanner input = new Scanner (System.in);
    private ArrayList<User> arr = new ArrayList<User>();

    public void addUser(User u)
    {
        arr.add(u);
    }

    public ArrayList<User> getArr() {
        return arr;
    }

    public void setArr(ArrayList<User> arr) {
        this.arr = arr;
    }

    public void deleteUser(int id)
    {
        arr.remove(arr.get(id));
    }

    public void newUser()
    {
        System.out.println ("Enter your first name :");
        String fName = input.next ();
        System.out.println ("Enter your last name :");
        String lName = input.next();
        System.out.println ("Enter your password : ");
        String pass = input.next ();
        System.out.println ("Enter your Email: ");
        String email = input.next ();
        User u = new User(fName,lName,pass,email);
        addUser(u);
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

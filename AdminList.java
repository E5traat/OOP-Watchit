import java.util.ArrayList;
import java.util.Scanner;

public class AdminList {
Scanner input = new Scanner (System.in);
    ArrayList<Admin> arrAdmin = new ArrayList<> ();
    public AdminList()
    {
        Admin a = new Admin("admin","admin","zaid","hany"
        ,"zaidhany112@gmail.com");
        arrAdmin.add(a);


    }
    public boolean adminExist(String username , String password)
    {
        for (Admin ad:arrAdmin) {
            if(ad.getUsername ().equals (username) && ad.getPassword ().equals (password))
                return true;

        }
        return false;
    }
     public void adminMenu()
     {
         System.out.println ();
         System.out.println ();
         System.out.println ();
         System.out.println ();
         System.out.println ("\t\t[1] Movies");
         System.out.println ("\t\t[2] Cast");
         System.out.println ("\t\t[3] Directors");
         System.out.println ("\t\t[4] Add new admin");
         System.out.println ("\t\t[5] Log out");

     }

    public void newAdmin()
    {
        System.out.println ("please fullfill the required details");
        System.out.println ();
        System.out.println ("Enter username");
        String username = input.next ();
        System.out.println ("Enter password");
        String password = input.next();
        System.out.println ("Enter first name");
        String fName = input.next();
        System.out.println ("Enter last name");
        String lname = input.next();
        System.out.println ("Enter your email");
        String email = input.next();
        Admin a = new Admin (username,password,fName,lname,email);
        addAdmin (a);

    }

    public void addAdmin (Admin a)
    {
        arrAdmin.add(a);
    }

    public void deleteAdmin (int index)
    {
        arrAdmin.remove (arrAdmin.get(index));
    }

    @Override
    public String toString() {
        return "AdminList{" +
                "arrAdmin=" + arrAdmin +
                '}';
    }
}

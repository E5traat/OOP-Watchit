import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner input = new Scanner (System.in);

    public static void main(String[] args) throws InterruptedException {

        AdminList a1 = new AdminList ();
        MovieList m1 = new MovieList ();
        CastList c1 = new CastList();
        DirectorList d1 = new DirectorList();
        UserList u1 = new UserList();
        System.out.println (a1.toString ());

        while (true) {
            boolean exist=false;
            System.out.println ("\t\t welcome to  Watchit");
            System.out.println ("\t\t have a good day");
            System.out.println ("\t[1] Log in");
            System.out.println ("\t[2] Sign up");
            System.out.println ("\t[3] exit");
            int choice = input.nextInt ();
            if (choice == 3) //exit
                break;
            else if (choice == 1) //log in
            {   while(true) {

                System.out.flush ();
                System.out.println ("Enter your username");
                String username = input.next ();
                System.out.println ("Enter your password");
                String password = input.next ();
                exist = a1.adminExist (username, password);

                if (exist == true) {
                     break;
                }
                else {
                    System.out.println ("\t\tinvalid username or password");
                    System.out.println ("\t\tplease try again");
                    continue;
                }
             }
            }


            else if(choice==2) //sign up user
            {
                u1.newUser();
                // u1.userMenu();
            }

            while(exist==true)
            {
                a1.adminMenu ();
                choice=input.nextInt ();
                if(choice==5)
                    break;
                else if(choice==1)
                {
                    while(true) {
                        m1.displayAllMovies ();
                        m1.movieMenu ();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            m1.newMovie ();
                          continue;
                        }
                        else if(choice==2) {
                            System.out.println ("please select one movie to update");
                            int index = input.nextInt ();
                            m1.updateMoviesMenu (index);
                            continue;
                        }
                        else if(choice==3)
                        {
                            System.out.println ("please select one movie to remove");
                            int index=input.nextInt ();
                            m1.deleteMovie (index);
                            continue;
                        }
                        else if(choice==4)
                        {
                            System.out.println ("enter the movie you want to see its details");
                            int index =input.nextInt ();
                            m1.showMovieDetails (index);
                        }
                        else if(choice==5)
                        {
                            break;

                        }
                    }

                }
                else if(choice == 2){

                    while(true) {
                        c1.displayAllActors();
                        c1.castMenu();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            c1.newCast ();
                            continue;
                        }
                        else if(choice==2) {
                            System.out.println ("please select one cast to update");
                            int index = input.nextInt ();
                            c1.updateCastsMenu (index);
                            continue;
                        }
                        else if(choice==3)
                        {
                            System.out.println ("please select one actor to remove");
                            int index=input.nextInt ();
                            c1.deleteCast (index -1);
                            continue;
                        }
                        else if(choice==4)
                        {
                            System.out.println ("enter the cast you want to see its details");
                            int index =input.nextInt ();
                            c1.showActorDetails(index);
                        }
                        else if(choice==5)
                        {
                            break;

                        }
                    }

                }
                else if(choice == 3){

                    while(true){
                        d1.displayAllDirectors();
                        d1.directorMenu();
                        choice = input.nextInt ();
                        if (choice == 1) {
                            d1.newDirector ();
                            continue;
                        }
                        else if(choice==2) {
                            System.out.println ("please select one director to update");
                            int index = input.nextInt ();
                            d1.updateDirectorsMenu (index);
                            continue;
                        }
                        else if(choice==3)
                        {
                            System.out.println ("please select one director to remove");
                            int index=input.nextInt ();
                            d1.deleteDirector (index);
                            continue;
                        }
                        else if(choice==4)
                        {
                            System.out.println ("enter the director you want to see its details");
                            int index =input.nextInt ();
                            d1.showDirectorDetails(index);
                        }
                        else if(choice==5)
                        {
                            break;

                        }
                    }
                }
            }



        }

    }
}


  /* MovieList m2 = new MovieList ();

 for(int i = 0 ;i<3 ;i++)
 {  //int id, int imdbScore, int budget, int revenue, String title,
    // String releaseDate, String runningTime, String country
     System.out.println("Fullfil the movire number "+ (i+1));
     System.out.println();
     System.out.println("enter imdbScore");
     int imdbscore=input.nextInt();
     System.out.println("enter movie budget");
     int budget = input.nextInt();
     System.out.println("enter revnue");
     int revnue = input.nextInt();
     System.out.println("enter movie title");
     String title =input.next();
     System.out.println("enter release");
     String date = input.next();
     System.out.println("enter duration");
     String duration = input.next();
     System.out.println("enter the country");
     String country = input.next();
     Movie m=new Movie(imdbscore,budget,revnue ,title,date,duration,country);
     System.out.println(m.toString());
     m2.addMovie (m);
 }

 System.out.println (m2.toString ());
*/

       /*
DirectorList d = new DirectorList ();

for(int i = 0 ;i<3 ;i++)
{
    System.out.println ("Enter the director details #"+(i+1));
    System.out.println ("Enter your first name ");
    String fName = input.next ();
    System.out.println ("Enter your last name ");
    String lName = input.next ();
    System.out.println ("Enter your age ");
    int age = input.nextInt ();
    System.out.println ("Enter your gender ");
    String gender = input.next ();
    System.out.println ("Etner your nationality");
    String nat=input.next ();
    Director d1 = new Director (fName,lName,gender,nat,age);
    d.addDirector (d1);
}

       System.out.println (d.toString ());

*/
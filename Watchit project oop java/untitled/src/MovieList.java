import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MovieList {
    Scanner input =new Scanner(System.in);
    private ArrayList<Movie> arr = new ArrayList();

   public void newMovie()
   {
       System.out.println("Fullfil the movie details");
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
       addMovie (m);
   }
    public void addMovie(Movie m)
    {
        arr.add(m);
    }

    public ArrayList<Movie> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Movie> arr) {
        this.arr = arr;
    }

    public void movieMenu()
    {
        System.out.println ("\t\tplease select on of the operations below");
        System.out.println ();
        System.out.println ("[1] Add movie");
        System.out.println ("[2] update movie");
        System.out.println ("[3] remove movie");
        System.out.println ("[4] show move details");
        System.out.println ("[5] back");
    }
    public void displayAllMovies()
    {
        System.out.println ("\t\t\t\t welcome to movies");
        if(arr.size()==0)
        {
            System.out.println ("\t\t\t\tthere is no movie right now");
        }
        else {
            for (int i = 0; i < arr.size (); i++) {
                System.out.println ("[" + (i + 1) + "] " + arr.get (i).getTitle ());
            }
        }
    }
    public void deleteMovie(int index)
    {
        arr.remove(arr.get(index-1));
    }
    public void showMovieDetails(int index)
    {
       arr.get (index-1).displayMovieDetails ();
    }
    public void movieDetailsMenu(int index)
    {
        System.out.println ("\t\tselect one of the operations below");
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] update\t\t[2] exit");
        int num=input.nextInt ();
        if(num==1) {
          this.updateMoviesMenu (index);
        }

    }




    public  void updateMoviesMenu(int index )
    {
        System.out.println ("\t\twelcome to update menu");
        System.out.println ("\tplease select one of operations to update the details");
        System.out.println ();
        System.out.println ();
        System.out.println ();
        System.out.println ("[1] Title\t\t[2] Release Date");
        System.out.println ();
        System.out.println ("[3] Running time\t\t[4] List of cast");
        System.out.println ();
        System.out.println ("[5] Genres\t\t[6] Director ");
        System.out.println ();
        System.out.println ("[7] Languages\t\t[8] imdb_score");
        System.out.println ();
        System.out.println ("[9] Country\t\t[10] Budget");
        System.out.println ();
        System.out.println ("[11] Revnue");
        System.out.println ("\t[12] Back ");
        int choice =input.nextInt ();
        if(choice==12)
            return;
        else
        this.updateMovie (index ,choice);
    }
    public void updateMovie(int index , int number)
    {
        if(number==1)
        {  String s =input.next();
            arr.get(index-1).setTitle(s);
        }
        if(number==2)
        {
            String s =input.next();
            arr.get(index-1).setReleaseDate (s);
        }
        if(number==3)
        {
            String s =input.next();
            arr.get(index-1).setRunningTime (s);
        }
        if(number==4)
        {
           displayCast(index);

        }

    }
    public void displayCast(int index)
    {  Movie m1 =new Movie();
        ArrayList<Cast> c1 = new ArrayList<> (m1.getArrCast ());
        int i ;
        if(c1.size ()==0) {
            System.out.println ("\t\tthere is no cast right now");
            System.out.println ("\tPlease select one of the operations below");
            System.out.println ();
            System.out.println ("[1] Add actor\t\t[2] Back");
             i=input.nextInt ();
             if(i==1)
             {
                 System.out.println ("Enter actor's first name :");
                 String fName = input.next ();
                 System.out.println ("Enter actor's last name :");
                 String lName = input.next();
                 System.out.println ("Enter actor's age : ");
                 int age = input.nextInt ();
                 System.out.println ("Enter actor's gender : ");
                 String gender = input.next ();
                 System.out.println ("Enter actor's nationality : ");
                 String nat = input.next ();
                 ArrayList<Movie> movies = new ArrayList<> ();
                 movies.add(m1);
                 Cast c = new Cast(fName,lName,gender,nat,age,movies);
                 c1.add (c);
                 arr.get(index-1).setArrCast (c1);

             }
             if(i==2)
             return;
             else
             {
                 System.out.println ("invalid operation\n please enter 1 or 2 only");
             }
        }

        else {

        }

    }


}

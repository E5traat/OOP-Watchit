import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public final int ID;
    public static int instance = 0;
    public String userName;
    private String password;
    public String firstName;
    public String lastName;
    public String email;
    public String subscription;
    public int moviesWatched;
    public ArrayList<Movie> laterMovies = new ArrayList<Movie>();
    public ArrayList<Movie> historyMovies = new ArrayList<Movie>();


    Scanner input = new Scanner(System.in);

    public User(){
        instance++;
        ID = instance;
    }

    public User(String userName, String firstName, String lastName, String password, String email){
        this();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;

    }
    public int getID() {
        return ID;
    }

    public String getUserName(){return userName;}
    public void setUserName(String name){userName=name;}
    public void showWatchHistory(){
        for(Movie m : historyMovies){
            System.out.println( (historyMovies.indexOf(m) + 1)  + ")" + m.getTitle());
        }
    }
    public void showWatchLater(){
        for(Movie m : laterMovies){
            System.out.println( (historyMovies.indexOf(m) + 1)  + ")" + m.getTitle());
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void watchMovie(int movieIndex){
        historyMovies.add(MovieList.arr.get(movieIndex));
        System.out.println("movie is watched successfully!");
    }
    public void watchMovieLater(int movieIndex){
        laterMovies.add(MovieList.arr.get(movieIndex));
        System.out.println("movie is added to later movies successfully!");
    }

}
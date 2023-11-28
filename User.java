import java.util.ArrayList;

public class User {
    public final int ID;
    public static int instance;
    private String password;
    public String firstName;
    public String lastName;
    public String email;
//    public Subscription subscription;
    public ArrayList<Movie> laterMovies = new ArrayList<Movie>();
    public ArrayList<Movie> historyMovies = new ArrayList<Movie>();

    public User(){
        ID = instance;
        instance++;
    }

    public User(String firstName, String lastName, String password, String email){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;

    }
    public int getID() {
        return ID;
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

}

import java.util.ArrayList;
import java.util.Arrays;

public class Cast extends Staff {
    public Cast() {
    }

    public Cast(String firstName, String lastName, String gender, String nationality, int age, ArrayList<Movie> movies) {
        super (firstName, lastName, gender, nationality, age, movies);

    }

    public Cast(String firstName, String lastName, String gender, String nationality, int age) {
        super (firstName, lastName, gender, nationality, age);

    }


    public void displayCastDetails() {
        System.out.println ("First Name : " + firstName);
        System.out.println ("Last Name : " + lastName);
        System.out.println ("Age :" + age);
        System.out.println ("Gender : " + gender);
        System.out.println ("Nationality : " + nationality);
    }


    @Override
    public String toString() {
        return "Cast{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", movies=" + movies +
                '}';
    }
}

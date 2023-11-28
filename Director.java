import java.util.ArrayList;

public class Director extends Staff{

    public Director() {
    }

    public Director(String firstName, String lastName, String gender, String nationality, int age) {
        super(firstName, lastName, gender, nationality, age);
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", movies=" + movies +
                '}';
    }
}

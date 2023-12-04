import java.util.ArrayList;


public  class Staff {

protected String firstName;
protected String lastName;
protected String gender;
protected String nationality;
protected int age;
protected ArrayList<Movie> movies = new ArrayList<>();

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    public void removeMovie(Movie movie){
        this.movies.remove(movie);
    }

    public Staff() {}

    public Staff(String firstName, String lastName, String gender, String nationality, int age, ArrayList<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
        this.movies = movies;
    }

    public Staff(String firstName, String lastName, String gender, String nationality, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }
}

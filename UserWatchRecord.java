import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserWatchRecord {
    private int userID;
    private String movieName;
    private String movieWatchDate;
    private float movieRating;

    public UserWatchRecord(int userID, String movieName) {
        this.userID = userID;
        this.movieName = movieName;
        this.movieRating = 0.0f;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.movieWatchDate = currentDateTime.format(formatter);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        userID = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String name) {
        movieName = name;
    }

    public String getMovieWatchDate() {
        return movieWatchDate;
    }

    public void setMovieWatchDate(String date) {
        movieWatchDate = date;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float rating) {
        movieRating = rating;
    }

}

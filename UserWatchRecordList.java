import java.util.ArrayList;

public class UserWatchRecordList {
    static ArrayList<UserWatchRecord> watchRecords = new ArrayList<> ();

    public void addRecord(UserWatchRecord r) {
        watchRecords.add (r);
    }

    public void removeRecords(int ID) {
        for (int i = 0; i < watchRecords.size (); i++) {
            if (watchRecords.get (i).getUserID () == ID) {
                watchRecords.remove (watchRecords.get (i));
            }
        }
    }

    static public float updateRating(int ID, String movieName, float rate) {
        for (UserWatchRecord watchRecord : watchRecords) {
            if (watchRecord.getUserID () == ID && watchRecord.getMovieName ().equals (movieName)) {
                watchRecord.setMovieRating (rate);
                break;
            }
        }
           return movieRate (movieName);
    }

    public static float movieRate(String title) {
        float sumRates = 0.0f;
        float counter = 0;
        for (UserWatchRecord watchRecord : watchRecords) {
            if (watchRecord.getMovieName ().equals (title)) {
                if (watchRecord.getMovieRating () != 0.0f) {
                    sumRates += watchRecord.getMovieRating ();
                    counter++;

                }
            }

        }
        if (counter != 0)
            return sumRates / counter;
        else
            return 0.0f;
    }


}

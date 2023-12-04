import java.util.ArrayList;

public class UserWatchRecordList {
    static ArrayList<UserWatchRecord> watchRecords = new ArrayList<>();

    public void addRecord(UserWatchRecord r) {
        watchRecords.add(r);
    }

    public void removeRecords(int ID){
        for (int i = 0; i < watchRecords.size(); i++) {
            if(watchRecords.get(i).getUserID() == ID){
                watchRecords.remove(watchRecords.get(i));
            }
        }
    }

    static public void updateRating(int ID,String movieName,float rate){
        for (UserWatchRecord watchRecord : watchRecords) {
            if (watchRecord.getUserID() == ID && watchRecord.getMovieName().equals(movieName)) {
                watchRecord.setMovieRating(rate);
            }
        }
    }

    static public float returnRate(int ID,String movieName){
        for (UserWatchRecord watchRecord : watchRecords) {
            if (watchRecord.getUserID() == ID && watchRecord.getMovieName().equals(movieName)) {
                return watchRecord.getMovieRating ();
            }
        }




    }

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Standard extends Subscription{

    private final int STANDARD_PRICE = 35;
    private final int MAX_WATCH = 10;
    public static int standard = 0;
    public static ArrayList<Subscription> arrStandard = new ArrayList<> ();


    public Standard(int userId, String plan) {
        super (userId, plan);
        Standard.standard++;
        LocalDateTime currentDateTime = LocalDateTime.now();
        super.setStartDate(currentDateTime);
        super.getMonth(currentDateTime,this.price);

    }
    public static void addSubscription(Standard sc)
    {
        arrStandard.add (sc);
    }//end of method

    public static void deleteSubscription(int userId)
    {
        for(int i =0 ;i< arrStandard.size() ; i++)
        {
            if(arrStandard.get(i).getUserId ()==userId)
            {
                arrStandard.remove (i);
            }

        }
    }//end of method
    public  boolean maxWatch(ArrayList arr)
    {
          if(arr.size()<this.MAX_WATCH) {
              return true;
          }
        return false;
    }
    public  boolean subDays(int userId)
    {
        for(int i=0 ;i<arrStandard.size() ; i++)
        {
            if(arrStandard.get(i).getUserId ()==userId)
            {
               int differnce = Subscription.getDifferenceDays
                       (arrStandard.get (i).getStartDate ());
               if(differnce<=30)
                   return  true;
               else
                   break;
            }
        }
        return  false;
    }
}

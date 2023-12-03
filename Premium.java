import java.time.LocalDateTime;
import java.util.ArrayList;

public class Premium extends Subscription{

    private final int PREMIUM_PRICE =50;
    private final int MAX_WATCH = 30;
    public static int premium = 0;
    public static ArrayList<Subscription> arrPremium = new ArrayList<> ();


    public Premium(int userId, String plan) {
        super (userId, plan);
        Premium.premium++;
        LocalDateTime currentDateTime = LocalDateTime.now();
        super.setStartDate(currentDateTime);
        super.getMonth(currentDateTime,this.price);

    }
    public static void addSubscription(Premium sc)
    {
        arrPremium.add (sc);
    }//end of method

    public static void deleteSubscription(int userId)
    {
        for(int i =0 ;i< arrPremium.size() ; i++)
        {
            if(arrPremium.get(i).getUserId ()==userId)
            {
                arrPremium.remove (i);
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
        for(int i=0 ;i<arrPremium.size() ; i++)
        {
            if(arrPremium.get(i).getUserId ()==userId)
            {
                int differnce = Subscription.getDifferenceDays
                        (arrPremium.get (i).getStartDate ());
                if(differnce<=30)
                    return  true;
                else
                    break;
            }
        }
        return  false;
    }
}

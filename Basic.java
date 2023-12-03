import java.time.LocalDateTime;
import java.util.ArrayList;

public class Basic extends Subscription {
    protected final int BASIC_PRICE =25;
    private final int MAX_WATCH = 5;

    public static int basic = 0;
    public static ArrayList<Subscription> arrBasic = new ArrayList<> ();




    public Basic(int userId, String plan) {
        super (userId, plan);
        Basic.basic++;
        LocalDateTime currentDateTime = LocalDateTime.now();
        super.setStartDate(currentDateTime);
        super.getMonth(currentDateTime,this.price);

    }
    public static void addSubscription(Basic sc)
    {
        arrBasic.add (sc);
    }//end of method

    public static void deleteSubscription(int userId)
    {
        for(int i =0 ;i< arrBasic.size() ; i++)
        {
            if(arrBasic.get(i).getUserId ()==userId)
            {
                arrBasic.remove (i);
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
        for(int i=0 ;i<arrBasic.size() ; i++)
        {
            if(arrBasic.get(i).getUserId ()==userId)
            {
                int differnce = Subscription.getDifferenceDays
                        (arrBasic.get (i).getStartDate ());
                if(differnce<=30)
                    return  true;
                else
                    break;
            }
        }
        return  false;
    }
}

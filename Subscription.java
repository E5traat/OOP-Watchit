import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static java.lang.Math.max;

public abstract class Subscription {

    public static int[] month = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//size==13 0 to 12
    protected int userId;
    protected int price;
    protected String plan;
    protected String startDate;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Subscription() {
    } // no arg constructor

    public Subscription(int userId, String plan) {

        this.userId = userId;
        this.plan = plan;
    }

    public void setStartDate(LocalDateTime currentDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        this.startDate = currentDateTime.format (formatter);
    }

    public void getMonth(LocalDateTime currentDateTime, int Price) {
        int monthValue = currentDateTime.getMonthValue ();
        month[monthValue] += Price;
    }

    public static void reduceMoney(String oldDateSub, int Price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse (oldDateSub, formatter);
        int monthValue = localDate.getMonthValue ();
        month[monthValue] -= Price;
    }


    public static int getDifferenceDays(String startDate1) {
        LocalDate oldDate = LocalDate.parse (startDate1);
        LocalDate currentDate = LocalDate.now ();
        int daysDifference = (int) ChronoUnit.DAYS.between (oldDate, currentDate);

        return daysDifference;
    }

    public static void subscribeAgain(int userId, int Price, String Plan) {
        LocalDateTime currentDateTime = LocalDateTime.now ();
        int monthValue = currentDateTime.getMonthValue ();
        month[monthValue] += Price;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        String newDate = currentDateTime.format (formatter);
        if (Plan.equals ("Basic")) {
            for (int i = 0; i < Basic.arrBasic.size (); i++) {
                if (Basic.arrBasic.get (i).getUserId () == userId)
                    Basic.arrBasic.get (i).setStartDate (newDate);
            }
        } else if (Plan.equals ("Standard")) {
            for (int i = 0; i < Standard.arrStandard.size (); i++) {
                if (Standard.arrStandard.get (i).getUserId () == userId)
                    Standard.arrStandard.get (i).setStartDate (newDate);


            }
        } else {
            for (int i = 0; i < Premium.arrPremium.size (); i++) {
                if (Premium.arrPremium.get (i).getUserId () == userId)
                    Premium.arrPremium.get (i).setStartDate (newDate);
            }
        }
    }

    public static void mostSuscribedPlan() {
        System.out.println ("\t\tThese all are subscribtions");
        System.out.println ();
        System.out.print ("Basic = " + Basic.arrBasic.size () + "\t");
        System.out.print ("Standard = " + Standard.arrStandard.size () + "\t");
        System.out.print ("Premuim = " + Premium.arrPremium.size ());
        System.out.println ();
        if (Basic.arrBasic.size () == Standard.arrStandard.size () &&
                Basic.arrBasic.size () == Premium.arrPremium.size ()) {
            System.out.println ("All plans are equal in number of subsctiptions");
        } else if (Basic.arrBasic.size () >= Standard.arrStandard.size () &&
                Basic.arrBasic.size () >= Premium.arrPremium.size ()) {
            System.out.println ("Basic is the most subscribed plan");
        } else if (Standard.arrStandard.size () >= Basic.arrBasic.size () &&
                Standard.arrStandard.size () >= Premium.arrPremium.size ()) {
            System.out.println ("Standard is the most subscribed plan");
        } else if (Premium.arrPremium.size () >= Basic.arrBasic.size () &&
                Premium.arrPremium.size () >= Standard.arrStandard.size ()) {
            System.out.println ("Premium is the most subscribed plan");
        }
    }

    public static void monthMostRevnue() {
        int maxi = 0;
        for (int i = 0; i < 13; i++) {
            maxi = max (maxi, month[i]);
        }
        System.out.print ("Month " + maxi + " had the most revnue ");
        System.out.print ("to the application");
        System.out.println ();

    }

    public static void updateSubscribtion(int userId, String oldSub, String newSub) {
        int index = 0;
        if (oldSub.equals ("Basic")) {
            for (int i = 0; i < Basic.arrBasic.size (); i++)//searching for index
            {
                if (Basic.arrBasic.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Standard")) {
                Standard st = new Standard (userId, newSub);
                Standard.addSubscription (st);
            } else {
                Premium pr = new Premium (userId, newSub);
                Premium.addSubscription (pr);
            }
            reduceMoney (Basic.arrBasic.get (index).getStartDate (), Basic.BASIC_PRICE);
            Basic.arrBasic.remove (index);


        } else if (oldSub.equals ("Standard")) {
            for (int i = 0; i < Standard.arrStandard.size (); i++)//searching for index
            {
                if (Standard.arrStandard.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Basic")) {
                Basic b = new Basic (userId, newSub);
                Basic.addSubscription (b);
            } else {
                Premium pr = new Premium (userId, newSub);
                Premium.addSubscription (pr);
            }
            reduceMoney (Standard.arrStandard.get (index).getStartDate (), Standard.STANDARD_PRICE);
            Standard.arrStandard.remove (index);
        } else if (oldSub.equals ("Premium")) {
            for (int i = 0; i < Premium.arrPremium.size (); i++)//searching for index
            {
                if (Premium.arrPremium.get (i).getUserId () == userId)
                    index = i;
            }
            if (newSub.equals ("Standard")) {
                Standard st = new Standard (userId, newSub);
                Standard.addSubscription (st);

            } else {
                Basic b = new Basic (userId, newSub);
                Basic.addSubscription (b);
            }
            reduceMoney (Premium.arrPremium.get (index).getStartDate (), Premium.PREMIUM_PRICE);
            Premium.arrPremium.remove (index);
        }
    }

    public void userSubcribtionDetails() {
        System.out.println ("User id : " + this.userId);
        System.out.println ("Subscription : " + this.plan);
        System.out.println ("price : " + this.price);
        System.out.println ("start date of subscription : " + this.startDate);
    }

    public abstract boolean maxWatch(ArrayList arr);

    public abstract boolean subDays(int userId);
}

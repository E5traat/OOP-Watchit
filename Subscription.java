import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static java.lang.Math.max;

public   abstract class Subscription {

    public static int [] month = {0,0,0,0,0,0,0,0,0,0,0,0,0};//size==13 0 to 12
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

    public Subscription() {} // no arg constructor

    public Subscription(int userId, String plan) {

        this.userId = userId;
        this.plan = plan;
    }

    public void setStartDate(LocalDateTime currentDateTime)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         this.startDate = currentDateTime.format(formatter);
    }
    public void getMonth(LocalDateTime currentDateTime, int Price)
    {
        int monthValue = currentDateTime.getMonthValue();
        month[monthValue]+=Price;
    }
    public static int getDifferenceDays(String startDate1)
    {
        LocalDate oldDate = LocalDate.parse(startDate1);
        LocalDate currentDate = LocalDate.now();
        int daysDifference = (int) ChronoUnit.DAYS.between(oldDate, currentDate);

        return  daysDifference;
    }

    public static void mostSuscribedPlan()
    {
        System.out.println ("\t\tThese all are subscribtions");
        System.out.println ();
        System.out.print ("Basic = " +Basic.basic+"\t");
        System.out.print ("Standard = " +Standard.standard+"\t");
        System.out.print ("Premuim = " +Premium.premium);
        System.out.println ();
        if(Basic.basic==Standard.standard &&
                Basic.basic==Premium.premium)
        {
            System.out.println ("All plans are equal in number of subsctiptions");
        }
        else if(Basic.basic>=Standard.standard &&
                Basic.basic>=Premium.premium)
        {
            System.out.println ("Basic is the most subscribed plan");
        }

        else if(Standard.standard>=Basic.basic &&
                Standard.standard>=Premium.premium)
        {
            System.out.println ("Standard is the most subscribed plan");
        }

        else if(Premium.premium>=Basic.basic &&
                Premium.premium>=Standard.standard)
        {
            System.out.println ("Premium is the most subscribed plan");
        }
    }
    public static void monthMostRevnue ()
    {
        int maxi =0;
        for(int i =0 ;i<13 ;i++) {
            maxi = max (maxi, month[i]);
        }
        System.out.print  ("Month " + maxi +" had the most revnue ");
        System.out.print  ("to the application");
        System.out.println ();

    }
    public static void updateSubscribtion (int userId , String oldSub , String newSub)
    {   int index = 0;
        if(oldSub.equals ("Basic"))
        {
            for(int i =0 ;i< Basic.arrBasic.size() ; i++)//searching for index
            {
                if(Basic.arrBasic.get (i).getUserId ()==userId)
                    index= i ;
            }
            if(newSub.equals ("Standard"))
                Standard.arrStandard.add (Basic.arrBasic.get(index));
            else
            {
                Premium.arrPremium.add(Basic.arrBasic.get(index));
            }
            Basic.arrBasic.remove(index);


        }

        else if(oldSub.equals ("Standard"))
        {
            for(int i =0 ;i< Standard.arrStandard.size() ; i++)//searching for index
            {
                if(Standard.arrStandard.get (i).getUserId ()==userId)
                    index= i ;
            }
            if(newSub.equals ("Basic"))
                Basic.arrBasic.add (Standard.arrStandard.get (index));
            else
            {
                Premium.arrPremium.add(Standard.arrStandard.get(index));
            }
            Standard.arrStandard.remove(index);
        }

        else if(oldSub.equals ("Premium"))
        {
            for(int i =0 ;i< Premium.arrPremium.size() ; i++)//searching for index
            {
                if(Premium.arrPremium.get (i).getUserId ()==userId)
                    index= i ;
            }
            if(newSub.equals ("Standard"))
                Standard.arrStandard.add (Premium.arrPremium.get (index));
            else
            {
                Basic.arrBasic.add(Premium.arrPremium.get(index));
            }
            Premium.arrPremium.remove(index);
        }
    }
    public void userSubcribtionDetails()
    {
        System.out.println ("User id : " + this.userId);
        System.out.println ("Subscription : " + this.plan);
        System.out.println ("price : " + this.price);
        System.out.println ("start date of subscription : "+ this.startDate);
    }

    public abstract boolean maxWatch(ArrayList arr);
    public abstract boolean subDays(int userId);
}

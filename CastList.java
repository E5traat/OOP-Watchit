import java.util.ArrayList;
import java.util.Scanner;

public class CastList {
Scanner input = new Scanner (System.in);
    private ArrayList<Cast> arr = new ArrayList();

    public void newCast()
    {
        System.out.println ("Enter actor's first name :");
        String fName = input.next ();
        System.out.println ("Enter actor's last name :");
        String lName = input.next();
        System.out.println ("Enter actor's age : ");
        int age = input.nextInt ();
        System.out.println ("Enter actor's gender : ");
        String gender = input.next ();
        System.out.println ("Enter actor's nationality : ");
        String nat = input.next ();
        Cast c = new Cast(fName,lName,gender,nat,age);
    }
    public void addCast(Cast m)
    {
        arr.add(m);
    }

    public ArrayList<Cast> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Cast> arr) {
        this.arr = arr;
    }

    public void deleteCast(int id)
    {
        arr.remove(arr.get(id));
    }

    @Override
    public String toString() {
        return "CastList{" +
                "arr=" + arr +
                '}';
    }
}

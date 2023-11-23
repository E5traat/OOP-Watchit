import java.util.ArrayList;

public class DirectorList {
    private ArrayList<Director> arr = new ArrayList();

    public void addDirector(Director m)
    {
        arr.add(m);
    }

    public ArrayList<Director> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Director> arr) {
        this.arr = arr;
    }



   public void displayListDirectors()
   {
       for(int i =0 ;i< arr.size() ; i++)
       {
           System.out.println(arr.get (i).toString ());
       }
   }
}

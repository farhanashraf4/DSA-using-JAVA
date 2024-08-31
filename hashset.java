import java.util.HashSet;
import java.util.Iterator;;
public class hashset {
    

    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set= new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Size of set
        System.out.println("Size of set: "+set.size());

        //Print all elements of set
        System.out.println(set);

        //Iterator imported via import java.util.Iterator;
        //Functions next(), hasNext() returns true or false 
        Iterator it= set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //search - contains()
        if (set.contains(1)) {
            System.out.println("set contains 1");
        }
        if (!set.contains(6)) {
            System.out.println("does not contains 6");
        }

        //Delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("doesnot contains 1 - we deleted 1");
        }
    }
}

import java.util.*;

public class Arraylists {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<Integer>();

        //add elements in list
        list.add(0);
        list.add(2);
        list.add(3);

        System.out.println(list);

        //get elements
        int elements= list.get(1);
        System.out.println(elements);

        //add elemnets in b/w
        list.add(1,1);//(in this first 1 is index where i want to add element 1 i.e., 2nd 1)
        System.out.println(list);

        //set elements
        list.set(0,5);//(in this first 0 is index where i want to set element 5 )
        System.out.println(list);

        //delete or remove elements
        list.remove(3);
        System.out.println(list);

        //size of Arraylist
        int size= list.size();
        System.out.println(size);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //sorting of Arraylist
        Collections.sort(list);
        System.out.println(list);
    }
}

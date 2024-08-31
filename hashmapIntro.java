import java.util.*;
public class hashmapIntro {
    public static void main(String[] args) {

        //country(key) , population(value)
        HashMap<String, Integer> map= new HashMap<>();
        
        //Insert
        map.put("India",140);
        map.put("USA", 30);
        map.put("China", 130);

        System.out.println(map);

        //update while inserting new value to key
        map.put("China", 135);
        System.out.println(map);

        System.out.println("");

        //Search if present using .containsKey() 
        if(map.containsKey("China")){
            System.out.println("key is present in the map");
        }else{
            System.out.println("key is not present in the map");
        }

        //Search if not present
        if(map.containsKey("Indonesia")){
            System.out.println("key is present in the map");
        }else{
            System.out.println("key is not present in the map");
        }

        System.out.println("");

        //To print or get values
        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

        /* JUST TO KNOW ABOUT DIFFERENT TYPE OF FOR LOOP
        int arr[]= {12,15,18};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
        for(int val:arr){
            System.out.print(val+" ");
        }
        */

        //for(int val: arr)
        //print using entrySet()
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.print(e.getValue()+" ");
        }

        System.out.println("");

        //print using keySet()
        Set<String> keys= map.keySet();
        for(String key: keys){
            System.out.println(key+" "+map.get(key));
        }

        //Remove
        map.remove("China");
        System.out.println(map);

    }
}

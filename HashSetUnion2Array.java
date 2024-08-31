import java.util.*;
public class HashSetUnion2Array {
    public static void Union(int arr1[],int arr2[]){
        HashSet<Integer> set= new HashSet<>();
        int n= arr1.length;
        int m= arr2.length;

        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }

        System.out.println(set);
        System.out.println(set.size());

    }
    public static void main(String[] args) {
        int arr1[]= {7,3,9};
        int arr2[]= {6,3,9,2,9,4};

        Union(arr1, arr2);
    }
}

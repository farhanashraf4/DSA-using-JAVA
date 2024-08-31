import java.util.Scanner;

public class quicksort {
    public static int partition(int arr[],int low, int high){
        int pivot =arr[high];
        int i= low-1;

        for(int j=low;j<high;j++){
            if (arr[j]<pivot) {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp= arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;

    }
    public static void quicksort(int arr[],int low, int high) {
        if (low<high) {
            int pindx= partition(arr, low, high);
            quicksort(arr, low, pindx-1);
            quicksort(arr, pindx+1, high);
            
        }
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size= sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter elements of Array:");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Array is:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        int n= arr.length;

        System.out.println("");
        System.out.println("Sorrted Array:");

        quicksort(arr, 0, n-1);

        //print
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

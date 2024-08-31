import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array size:");
        int size= sc.nextInt();
        int arr[]=new int[size];

        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){

                if(arr[j]>arr[j+1]){

                int temp= arr[j];
                arr[j]=arr[j+1];
                arr[j+1]= temp;
                }

            }
        }
        printArray(arr);

    }
    public static void printArray(int arr[]){
        System.out.println("print sorted array:");
        for(int i=0;i<arr.length;i++){
            
            System.out.print(arr[i]+ " ");

        }
    }



}

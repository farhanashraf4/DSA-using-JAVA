import java.util.Scanner;

public class selectionsort {

    public static void printArray(int arr[]){
        System.out.println("print sorted array:");
        for(int i=0;i<arr.length;i++){
            
            System.out.print(arr[i]+ " ");

        }
    }

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
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){

                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;

        }
        printArray(arr);

    }
  


}

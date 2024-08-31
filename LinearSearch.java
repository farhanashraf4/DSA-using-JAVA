public class LinearSearch {
    // Linear search function
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Key found, return the index
            }
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int key = 10;

        int result = linearSearch(arr, key);

        if (result == -1) {
            System.out.println("Element not present in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

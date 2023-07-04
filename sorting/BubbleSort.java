import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSortAlgo(int[] arr) {
        
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
        
            for (int j = 0; j < n - i - 1; j++) {
        
                if (arr[j] > arr[j + 1]) {
        
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
        
                }

            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {624, 33, 25, 10, 23, 91, 90};
        System.out.println(Arrays.toString(arr));

        bubbleSortAlgo(arr);

        System.out.println(Arrays.toString(arr));
    }

}
import java.util.Arrays;

public class Quicksort {

    // thingy to make it easier to call
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    // end is inclusive; the index of the last element
    public static void quicksort(int[] arr, int start, int end) {
        if (start < end) { // base case does nothing
            int p = partition(arr, start, end);
            quicksort(arr, start, p-1);
            quicksort(arr, p+1, end);
        }
    }

    // magic
    private static int partition(int[] arr, int start, int end) {
        int pv = arr[end]; // pivot value is whatever the last element is
        int i = 0; 
        for (int j = 0; j < end; j++) {
            if (arr[j] <= pv) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    // swaps elements as indexes a and b
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // test
    public static void main(String[] args) {
        int[] test = {3, 2, 8, 10, 4, 2, 9, 5, 6};
        System.out.println(Arrays.toString(test));
        quicksort(test);
        System.out.println(Arrays.toString(test));
    }


}
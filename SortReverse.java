import java.util.Arrays;

/**
 * Sort an array of integers and print the results in descending order
 */
public class SortReverse {

    public static void main(String[] args) {
        int[] arr = {9,4,7,0,-2,4,5,-9,100};
        sortReverse(arr);
    }

    private static int[] sortReverse(int[] arr) {
        if(arr == null || arr.length == 0) throw new IllegalArgumentException("invalid input");
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--)
            System.out.println(arr[i]);
        return arr;
    }

}

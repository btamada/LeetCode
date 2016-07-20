/**
 * Quick Sort
 */
public class QuickSortAlgorithm {

    private static int[] numbers;
    private static int number;

    public static void main(String[] args) {
        int[] values = {-4,0,5,20,34,99,-30,-100};
        quicksort(values);
        for(int i = 0; i < numbers.length; ++i)
            System.out.println(numbers[i]);
    }

    private static void quicksort(int[] values) {
        if(values == null || values.length == 0) return;
        numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];
        while(i <= j) {
            while(numbers[i] < pivot) i++;
            while(numbers[j] > pivot) j--;
            if(i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if(low < j) quicksort(low, j);
        if(i < high) quicksort(i, high);
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}

/**
 * Merge Sort
 */
public class MergeSortAlgorithm {

    private static int[] numbers;
    private static int[] helper;
    private static int number;

    public static void main(String[] args) {
        int[] values = {-4,0,5,20,34,99,-30,-100};
        sort(values);
        for(int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }
    }

    private static void sort(int[] values) {
        numbers = values;
        number = values.length;
        helper = new int[number];
        mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {
        for(int i = low; i <= high; ++i) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while(i <= middle && j <= high) {
            if(helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // insert remaining objects into the numbers array
        while(i <= middle) {
            numbers[k] = helper[i];
            i++;
            k++;
        }

    }

}

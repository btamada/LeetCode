import java.util.TreeSet;

/**

 Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:
 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]
 Credits:
 Special thanks to @elmirap for adding this problem and creating all test cases.

 */
public class SortTransformedArray {

    public static void main(String[] args) {
        int[] nums = {-4, -2, 2, 4};
        int a = 1;
        int b = 3;
        int c = 5;
        for(int n : sortTransformedArray(nums,a,b,c)) {
            System.out.println(n);
        }
    }

    private static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return null;

        // calculate the numbers and put them back into the array
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = (a * (int)Math.pow(x,2)) + (b * (x)) + c;
        }

        // put the numbers into a tree set to sort them
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }

        // iterate through the tree set putting numbers back into array
        int itr = 0;
        for(Integer n : treeSet) {
            nums[itr++] = n;
        }

        // return the array in sorted order
        return nums;
    }

}

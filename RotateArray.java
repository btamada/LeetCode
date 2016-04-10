import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        rotateArray(nums, 3);

        for(int n : nums) System.out.println(n);
    }

    /**
     *  Algorithm Design:
     *
     *  Solutions 1:
     *      iterate through the nums array
     *          place the value at nums[i] into a new array where the index is
     *          determined by adding k steps to the index and modding by the length
     *          of the nums array
     *      return the new array
     *
     *  Solutions 2:
     *
     *
     *  Solutions 3:
     *
     */
    static void rotateArray(int[] nums, int k) {
        if(nums == null || nums.length == 0) throw new IllegalArgumentException("Invalid input!");

        int len = nums.length;

        int[] newNums = Arrays.copyOfRange(nums,0,nums.length);

        for(int i = 0; i < newNums.length; ++i) {
            nums[ (i + k) % len] = newNums[i];
        }
    }

}

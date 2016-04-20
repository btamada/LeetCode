/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class RangeSumQuery {

    private int[] prefix_sums;
    private int[] original_nums;

    public RangeSumQuery(int[] nums) {
        if(nums.length > 0)
        {
            prefix_sums = new int[nums.length];
            original_nums = nums.clone();
            prefix_sums[0] = nums[0];

            for(int i = 1; i < nums.length; i++) {
                prefix_sums[i] = nums[i] + prefix_sums[i - 1];
            }
        }
    }

    private int sumRange(int i, int j) {
        return prefix_sums[j] - prefix_sums[i] + original_nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println(rsq.sumRange(0,2));
        System.out.println(rsq.sumRange(2,5));
        System.out.println(rsq.sumRange(0,5));
    }



}

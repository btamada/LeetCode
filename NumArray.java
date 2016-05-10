/**

 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.


 */
public class NumArray {

    int[] numbers;

    int[] sums;

    public NumArray(int[] nums) {
        this.numbers = nums;
        this.sums = new int[nums.length + 1];
    }

    public int[] prefixSum(int[] numbers) {

        for(int i = 0; i < sums.length; i++) {
            sums[i] = 0;
        }

        sums[0] = numbers[0];

        for(int i = 1; i < numbers.length; i++) {
            sums[i] = sums[i-1] + numbers[i];
        }

        return sums;
    }

    public int sumRange(int i, int j) {
        sums = prefixSum(numbers);

        if(i == 0) return sums[j];

        return sums[j] - sums[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }

}

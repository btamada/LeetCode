/**
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {6,3,10,8,2,10,3,5,10,5,3};
        System.out.println(rob(nums));
    }

    /**
     * Algorithm Design
     *
     * @param nums
     * @return
     *
     */
    static int rob(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int temp = b;
            b = Math.max(nums[i] + a, b);
            a = temp;
        }
        return b;
    }
}
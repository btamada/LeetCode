/**

 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 Time: O(N)
 Space: O(1)

 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {5,1,5,5,2,5,4};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;

        int k = nums[nums.length - 1];
        int j = nums[nums.length - 2];
        int i = nums[nums.length - 3];

        for(int itr = nums.length - 3; itr >= 0; itr--) {
            if(nums[itr + 2] > k) {
                k = nums[itr + 2];
                j = nums[itr + 1];
            }

            if(nums[itr + 1] < k && nums[itr + 1] > i) {
                j = nums[itr + 1];
                i = nums[itr];
            }

            if(nums[itr] < j && nums[itr] <= i) {
                i = nums[itr];
            }

            if((i < j) && (j < k)) return true;
        }

        System.out.println("k: " + k);
        System.out.println("j: " + j);
        System.out.println("i: " + i);

        return false;
    }

}

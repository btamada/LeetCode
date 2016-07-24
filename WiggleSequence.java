/**

 Find the max number of integers that alternate between positive and negative differences.

 Input: [1,7,4,9,2,5]
 Output: 6
 The entire sequence is a wiggle sequence.

 Input: [1,17,5,10,13,15,10,5,16,8]
 Output: 7
 There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

 Input: [1,2,3,4,5,6,7,8,9]
 Output: 2

 */
public class WiggleSequence {

    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }

    private static int wiggleMaxLength(int[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("invalid input");
        int maxCount = 1;
        boolean isPositive = true;
        for(int i = 1; i < arr.length; i++) {
            if(isPositive && arr[i] > arr[i-1]) {
                ++maxCount;
                isPositive = false;
            }
            else if(!isPositive && arr[i-1] >= arr[i]) {
                ++maxCount;
                isPositive = true;
            }
        }
        return maxCount;
    }

}

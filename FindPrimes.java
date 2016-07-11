/**

 Find all primes given an integer N

 */
public class FindPrimes {

    public static void main(String[] args) {
        int N = 5;
        int[] nums = {10,5,3,15,16};
        findPrimes(nums, N);
    }

    private static void findPrimes(int[] nums, int N) {
        if(nums == null || nums.length == 0) return;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == N)
                System.out.print(nums[i] + " ");
            else if (nums[i] % N != 0)
                System.out.print(nums[i] + " ");
        }
    }



}

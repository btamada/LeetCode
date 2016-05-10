import java.util.Arrays;

/**
 *
 * Fun with Dynamic Programming
 *
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        int[] coins = {1, 3, 4};
        System.out.println(coinDenom(coins, 17));

    }

    static int fib(int n) {
        return fibHelp(n, new int[n+1]);
    }

    static int fibHelp(int n, int[] memo) {
        if(n == 0 || n == 1) return n;
        if(memo[n] == 0) {
            memo[n] = fibHelp(n - 1, memo) + fibHelp(n - 2, memo);
        }
        return memo[n];
    }

    static int countSteps(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
    }

    static int countStepsMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countStepsMemoHelper(n, memo);
    }

    static int countStepsMemoHelper(int n, int[] memo) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] > -1) return memo[n];
        memo[n] = countStepsMemoHelper(n - 1, memo) +
                countStepsMemoHelper(n - 2, memo) +
                countStepsMemoHelper(n - 3, memo);
        return memo[n];
    }

    /**
     *
     * Given coins with values 1, 3 and 5
     * The sum S is set to be 11
     *
     * Sum 2
     * 2 - 1 == 1
     * coinSums[1] == 1
     * 1 + 1 == 2
     *
     * Sum 3
     * 3 - 1 == 2
     * coinSums[2] == 2
     * 1 + 2 == 3
     *
     * OR
     *
     * 3 - 3 == 0
     * coinSums[0] == 0
     * 1 + 0 == 1
     *
     */
    static int coinSum(int n) {
        if(n < 0) return -1;
        if(n == 0) return 0;
        if(n == 1) return 1;

        int[] coinSums = new int[n + 1];
        int coinOne = 1;
        int coinThree = 3;
        int coinFive = 5;

        Arrays.fill(coinSums, -1);

        coinSums[0] = 0; // we know that there are zero coins to construct a sum of 0
        coinSums[1] = 1; // we know that there is only one coin to construct a sum of 1

        int minSum = 0;

        for(int i = 2; i <= n; i++) {

            // determine if the coin value is less than or equal to the current sum, i
            if(coinFive <= i) {
                int diff = i - coinFive;
                coinSums[i] = coinSums[diff] + 1;
            } else if (coinThree <= i) {
                int diff = i - coinThree;
                coinSums[i] = coinSums[diff] + 1;
            } else if (coinOne <= i) {
                int diff = i - coinOne;
                coinSums[i] = coinSums[diff] + 1;
            }

            //System.out.println("Index " + i +  " is " + coinSums[i]);

        }

        return coinSums[n];
    }

    /**
     *
     * Dynamic Programming
     * Recurrent Relation: Connection between a lower and greater state
     *
     * Problem
     * Find the length of the longest non-decreasing sequence
     *
     * State == sub-problem
     *
     * Example:
     * [5, 3, 4, 8, 6, 7]
     *
     */
    static int longestSequence(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int currSmallestNum = nums[0];
        int currLongestSeq = Math.abs(nums[0] - nums[1]);

        for(int i = 2; i < nums.length; i++) {

            // find the difference between current num and the smallest num found
            int diff = Math.abs(nums[i] - currSmallestNum);

            // check if the difference is bigger than the current difference we found
            if(diff > currLongestSeq) currLongestSeq = diff;

            // update the current smallest to the new value if the latter is smaller
            if(nums[i] < currSmallestNum) currSmallestNum = nums[i];
        }

        return currLongestSeq;
    }

    /**
     * Intermediate Dynamic Programming
     *
     * Problem: Max Apples
     * You start from the upper-left corner.  At each step you can go down or right one cell.
     * Find the maximum number of apples you can collect.
     *
     * {0, 0, 0, 1, 0, 1}  2
     * {1, 1, 0, 0, 1, 0}  2
     * {0, 1, 0, 0, 1, 1}  3
     *
     *  1  2  0  1  2  2
     *
     *
     */

    static int findMostApples(int[][] apples) {

        int[][] state = new int[apples.length][apples[0].length];

        //Arrays.fill(state, 0);

        for(int i = 0; i < apples.length; i++) {

            for(int j = 0; j < apples[0].length; j++) {

                if(i > 0 && j > 0)
                    state[i][j] = apples[i][j] + Math.max(state[i-1][j],state[i][j-1]);
                else
                    state[i][j] = apples[i][j];

            }

        }

        return state[apples.length - 1][apples[0].length - 1];
    }

    /**
     * Intermediate Dynamic Programming

     Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively. The price of the i-th wine is pi (prices of different wines can be different).

     Because the wines get better every year, supposing today is the year 1, on year y the price of the i-th wine will be y*pi, i.e. y-times the value that current year.

     You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).

     You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order.

     So for example, if the prices of the wines are (in the order as they are placed on the shelf, from left to right): p1=1, p2=4, p3=2, p4=3
     The optimal solution would be to sell the wines in the order p1, p4, p3, p2 for a total profit 1*1 + 3*2 + 2*3 + 4*4 = 29

     */
    static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        if(prices.length == 1) return prices[0];

        int maxProfit = 0;

        maxProfit = findProfit(prices, 1, 0, prices.length - 1);

        return maxProfit;
    }

    // using backtracking and recursion to find the maximum profit
    static int findProfit(int[] prices, int year, int start, int end) {
        if(start > end) return 0;

        return Math.max(
                findProfit(prices, year + 1, start + 1, end) + (year * prices[start]),
                findProfit(prices, year + 1, start, end - 1) + (year * prices[end])
        );
    }

    /**
     *
     *  Longest Increasing Subsequence (LIS)
     *
     *  Example:
     *  {1,2,3,4,5,6,7,8,9}
     *
     *  Using the bottom-up approach (iterative)
     *
     */
    static int longIncrSub(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int longestSubsequence = 1;

        int tmpCurrLong = 1;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i-1] < nums[i])
                ++tmpCurrLong;
            else
                tmpCurrLong = 1;

            longestSubsequence = Math.max(tmpCurrLong,longestSubsequence);
        }

        return longestSubsequence;
    }

    /**
     * Coin Denomination
     *
     * Coins: {1, 3, 4}
     *
     */
    static int coinDenom(int[] coins, int sum) {
        if(coins == null || coins.length == 0) return 0;
        if(coins.length == 1) return 1;

        int[] coinSums = new int[sum + 1];

        coinSums[0] = 0;

        for(int i = 1; i < coinSums.length; i++) {

            for(int k = coins.length - 1; k >= 0; k--) {

                if(i >= coins[k]) {
                    int diff = Math.abs(coins[k] - i);
                    coinSums[i] = coinSums[diff] + 1;
                    break;
                }

            }

        }

        return coinSums[sum];
    }

}

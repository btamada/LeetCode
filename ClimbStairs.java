/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println("Recursive: " + climbStairs1(30));
        System.out.println("Iterative: " + climbStairs2(30));
    }

    static int climbStairs1(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 2;
        if(memo[n] == 0) {
            memo[n] = climbStairs1(n - 1) + climbStairs1(n - 2);
        }
        return memo[n];
    }

    /**
     *
     * Algorithm Design
     *
     *
     * NOTE: Only 1 or 2 steps at a time
     * Time: O(N)
     * Space: O(1)
     *
     * @param n - number of steps to reach the top
     * @return - number of distinct ways to climb the top
     */
    static int climbStairs2(int n) {
        if(n <= 0) return 0;
        int a = 1, b = 2, c = 0;
        for(int i = 2; i < n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return n <= 2 ? n : c;
    }

}

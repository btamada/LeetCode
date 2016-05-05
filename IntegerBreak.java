/**

 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: you may assume that n is not less than 2.

 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(4));
    }

    /**
     *  Algorithm Design
     *
     *  Time Complexity: O(logn), due to Math.pow() function
     *  Space Complexity: O(1)
     *
     *  - Break down the integer into its factors
     *  - Find the greatest product of the factors
     *  - Return the greatest product
     */

    static int integerBreak(int n) {

        if(n == 2) return 1;

        int maxProduct = 0;

        // case: no remainder
        if (n % 3 == 0) {
            if(n == 3) {
                maxProduct = 2;
            } else {
                int countOf3s = n / 3;
                maxProduct = (int) Math.pow(3,countOf3s);
            }
        }

        // case: remainder of 1
        if (n % 3 == 1) {
            int rem = n - 4;
            int countOf3s = rem / 3;
            maxProduct = (int) Math.pow(3,countOf3s) * 2 * 2;
        }

        // case: remainder of 2
        if (n % 3 == 2) {
            int countOf3s = n / 3;
            maxProduct = (int) Math.pow(3,countOf3s) * 2;
        }

        return maxProduct;
    }
}

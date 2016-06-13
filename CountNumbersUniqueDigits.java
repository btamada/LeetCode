/**

 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 */
public class CountNumbersUniqueDigits {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(0));
    }

    private static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int result = 1;
        int availableDigits = 9;
        int temp = 1;

        for (int i=0; i<n; i++) {
            if (i>1) availableDigits -= 1;
            temp *= availableDigits;
            result += temp;
        }
        return result;
    }

}

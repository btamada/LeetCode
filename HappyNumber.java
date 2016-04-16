import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum
 * of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a
 * cycle which does not include 1. Those numbers for which this process
 * ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    static boolean isHappy(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        int num1 = n;
        int num2 = n;
        int tmp = 0;
        Set<Integer> set = new HashSet<>();
        while(num1 > 1) {
            tmp = 0;
            num2 = num1;
            while (num2 > 0) {
                int rem = num2 % 10;
                tmp += (int) Math.pow(rem,2);
                num2 = num2 / 10;
            }
            num1 = tmp;
            if(set.contains(num1)) return false;
            set.add(num1);
        }

        return num1 == 1;
    }

}

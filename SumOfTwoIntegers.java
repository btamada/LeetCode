/**

 Add two integers without using the + or - operators

 1 == 0001
 -1 == 1110 + 0001 == 1111

 2 == 0010
 -2 == 1101 + 0001 == 1110

 3 == 0011
 -3 == 1100 + 0001 == 1101

 7 == 0111
 1 == 0001

 a == 0110 (6)
 b == 0010 (2)

 a == 0100 (4)
 b == 0100 (4)

 a == 0000 (0)
 b == 1000 (8)

 a == 1000 (8)
 b == 0000 (0)

 */
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(~3 + 1);
    }

    private static int getSum(int a, int b) {
        if(b == 0) return a;
        int sum,carry;
        sum = a^b;
        carry = (a&b)<<1;
        return getSum(sum,carry);
    }

}

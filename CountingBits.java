/**

 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:
 It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 Can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).

 Can you do it like a boss?
 Do it without using any builtin function like __builtin_popcount in c++ or
 in any other language.

 */
public class CountingBits {

    public static void main(String[] args) {
        for(Integer i : countBitsLoop(5)) System.out.println(i);
        System.out.println();
        for(Integer i : countBitsFunc(5)) System.out.println(i);
    }

    static int[] countBitsFunc(int num) {
        int[] num1Bits = new int[num + 1];
        num1Bits[0] = 0;
        if(num == 0) return num1Bits;

        num1Bits[1] = 1;
        if(num == 1) return num1Bits;

        for(int i = 2; i <= num; i++) {
            num1Bits[i] = Integer.bitCount(i);
        }

        return num1Bits;
    }

    static int[] countBitsLoop(int num) {
        int[] num1Bits = new int[num + 1];
        num1Bits[0] = 0;
        if(num == 0) return num1Bits;

        num1Bits[1] = 1;
        if(num == 1) return num1Bits;

        for(int i = 2; i <= num; i++) {

            int tmp = i;
            int countOf1s = 0;

            // count number of set bits
            while(tmp > 0) {
                if( (tmp & 1) == 1) ++countOf1s;
                tmp >>>= 1;
            }

            num1Bits[i] = countOf1s;
        }

        return num1Bits;
    }

}

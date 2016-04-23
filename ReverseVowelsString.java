/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 */
public class ReverseVowelsString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("Aa"));
    }

    static String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();

        char[] sChar = s.toCharArray();

        int head = 0;
        int tail = sChar.length - 1;

        while(head < tail) {
            if("AEIOUaeiou".indexOf(sChar[tail]) == -1) {
                --tail;
                continue;
            }
            else if("AEIOUaeiuo".indexOf(sChar[head]) == -1) {
                ++head;
                continue;
            } else {
                char tmp = sChar[head];
                sChar[head] = sChar[tail];
                sChar[tail] = tmp;
                --tail;
                ++head;
            }
        }

        return sb.append(sChar).toString();
    }

}

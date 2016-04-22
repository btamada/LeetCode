/**
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.


 *
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    static int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        return strArr.length <= 0 ? 0 : strArr.length == 1 ? strArr[0].length() : strArr[strArr.length - 1].length();
    }

}

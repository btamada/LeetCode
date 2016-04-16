import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(largestNumber(nums));
    }

    static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";

        String[] numString = new String[nums.length];

        for(int i = 0; i < nums.length; ++i)
            numString[i] = String.valueOf(nums[i]);

        // a method to compare two strings
        Arrays.sort(numString, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str1.compareTo(str2);
            }
        });

        if(numString[numString.length-1].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();

        for(String s : numString) {
            sb.insert(0,s);
        }

        return sb.toString();
    }

}

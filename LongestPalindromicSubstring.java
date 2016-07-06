/**

 Given a string, find the longest substring which is palindrome.
 For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.

 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalSubstr("forgeeksskeegfor"));
    }

    private static int longestPalSubstr(String str) {
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException("invalid input");
        int maxLen = 1;
        int len = str.length();
        char[] arr = str.toCharArray();
        int low, high;
        for(int i = 1; i < len; ++i) {

            // find the longest even length palindrome
            low = i - 1;
            high = i;
            while(low >= 0 && high < len  && arr[low] == arr[high]) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                }
                --low;
                ++high;
            }

            // find the longest odd length palindrome
            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < len && arr[low] == arr[high]) {
                if(high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return maxLen;
    }

}

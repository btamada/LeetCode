/**
 *
 * Find the longest palindromic substring
 *
 */
public class LongestPalinString {

    public static void main(String[] args) {
        System.out.println(longestPalindromeOpt("racecar"));
    }

    /**
     * My Solution
     * *NOTE* Timeout when dealing with large strings
     *
     * Time Complexity: O(n**2)
     * Space Complexity: O(n)
     */
    static String longestPalindromeNaive(String s) {
        if (s.length() < 2) return s;

        // get the starting index
        int start = 0;

        // get the ending index
        int end = s.length() - 1;

        // holds the longest palindrome
        String longestPalin = "";

        StringBuilder leftPalin = new StringBuilder();
        StringBuilder rightPalin = new StringBuilder();

        // O(N)
        for(int i = start; i < end; i++) {

            // reset the stringbuilders
            leftPalin.setLength(0);
            rightPalin.setLength(0);

            int innerStart = i;
            int innerEnd = end;

            // O(N)
            while(innerStart < innerEnd) {

                //System.out.println("innerStart: " + innerStart);
                //System.out.println("innerEnd: " + innerEnd);

                // the characters are not the same
                // move the end point to the left one place
                if(s.charAt(innerStart) != s.charAt(innerEnd)) {
                    rightPalin.setLength(0);
                    --innerEnd;
                } else { // characters are the same
                    leftPalin.append(s.charAt(innerStart));

                    if(innerEnd == innerStart + 3) { // more than 2 elements in between, so not palindrome
                        leftPalin.setLength(0);
                        rightPalin.setLength(0);
                        ++innerStart;
                        --innerEnd;
                    } else if(innerStart + 2 == innerEnd) { // we reached the middle of the palindrome
                        rightPalin.insert(0, s.substring(innerStart + 1, innerEnd + 1));
                        ++innerStart;
                        --innerEnd;
                    } else {
                        rightPalin.insert(0, s.charAt(innerEnd));
                        ++innerStart;
                        --innerEnd;
                    }
                }
            }

            // check if the current palindrome size is bigger than the currently saved palindrome
            if(longestPalin.length() < (leftPalin.length() + rightPalin.length()))
                longestPalin = leftPalin.toString() + rightPalin.toString();
        }

        return longestPalin;
    }

    /**
     * Optimized Solution from LeetCode Dicussion
     */
    static String longestPalindromeOpt(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    static boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

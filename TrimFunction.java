/**
 * Implement the Trim function
 */
public class TrimFunction {

    public static void main(String[] args) {
        System.out.println(trim("  abc  def    "));
    }

    private static String trim(String s) {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("invalid input");
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        while(start <= end) {
            sb.append(s.charAt(start));
            start++;
        }
        return sb.toString();
    }

}
/**
 * Swap pairs of characters in a string
 */
public class SwapCharacters {

    public static void main(String[] args) {
        System.out.println(swapChars("ABCDEFG"));
    }

    private static String swapChars(String s) {
        if(s == null || s.length() == 0) throw new IllegalArgumentException("invalid input");
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 1; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
            sb.append(s.charAt(i-1));
        }
        if(i == s.length()) sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

}

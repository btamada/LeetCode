/**
 * Remove duplicates from a string
 */
public class RemoveDuplicatesFromString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbbcccccaadddeeeee"));
    }

    private static String removeDuplicates(String s) {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("invalid input");
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        char head = s.charAt(0);
        sb.append(head);
        for(int i = 0; i < s.length();) {
            char itr = s.charAt(++i);
            while (head == itr && i < s.length()) itr = s.charAt(i++);
            if(head != itr) {
                head = itr;
                sb.append(head);
            }
        }
        return sb.toString();
    }

}

import java.util.HashSet;
import java.util.Set;

/**

 Determine if the string input contains all unique letters.

 */
public class UniqueAlphabet {

    public static void main(String[] args) {
        System.out.println(uniqueAlphabet("abcd efgh ijkl mnop qrst uvwx yz"));
    }

    private static boolean uniqueAlphabet(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.replaceAll("\\s+", "").trim();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); ++i) {
            if(set.contains(s.charAt(i))) return false;
            else set.add(s.charAt(i));
        }
        return set.size() == 26 ? true : false;
    }

}

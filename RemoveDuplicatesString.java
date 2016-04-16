import java.util.HashSet;
import java.util.Set;

/**
 * Time: O(N)
 * Space: O(N)
 */
public class RemoveDuplicatesString {

    public static void main(String[] args) {
        System.out.println(removeDuplicatesNoDS("abcdeffggghijkkkkkkklmmmnnoopppppqrssstuvwwxxxyz"));
    }

    static String removeDuplicatesNoDS(String s) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++) {
            if(!result.contains(s.substring(i-1,i))) {
                result += s.substring(i-1,i);
            }
        }
        return result + s.substring(s.length() - 1);
    }

    static String removeDuplicates(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> mySet = new HashSet<>();
        for(int i = 0; i < charArr.length; i++) {
            if(!mySet.contains(charArr[i])) {
                mySet.add(charArr[i]);
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
}

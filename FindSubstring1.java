/**
 * Find if a string is a substring in another string
 */
public class FindSubstring1 {

    public static void main(String[] args) {
        System.out.println(findSubstring("oob","foobar"));
    }

    private static boolean findSubstring(String sub, String str) {
        if(sub == null || str == null || sub.length() == 0 || str.length() == 0)
            throw new IllegalArgumentException("invalid input");
        StringBuilder currSubStr = new StringBuilder();
        for(int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == sub.charAt(0)) {
                for (int k = 0; k < sub.length(); ++k)
                    currSubStr.append(sub.charAt(k));
                if (currSubStr.toString().equalsIgnoreCase(sub)) return true;
                else currSubStr.setLength(0);
            }
        }
        return false;
    }

}

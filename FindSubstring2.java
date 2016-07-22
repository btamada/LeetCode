/**
 * Find if a string is a substring in another string
 */
public class FindSubstring2 {

    public static void main(String[] args) {
        System.out.println(findSubstring2("oob","foobar"));
    }

    private static boolean findSubstring2(String sub, String str) {
        if(sub == null || str == null || sub.length() == 0 || str.length() == 0)
            throw new IllegalArgumentException("invalid input");
        sub = sub.toLowerCase();
        str = str.toLowerCase();
        return (sub.length() <= str.length() && str.indexOf(sub) != -1);
    }

}

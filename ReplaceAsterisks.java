/**

 Given a string with pairs of asterisks in it, like "
 This is *a test*.", replace the asterisks with bold tags <b> and </b>.
 If there's a backslash in front of an asterisk, instead leave the asterisk intact.
 So "Two \* two = *four*" becomes "Two * two = <b>four</b>".

 */
public class ReplaceAsterisks {

    public static void main(String[] args) {
        System.out.println(replaceAsterisks("Two \\* two = *four*"));
    }

    private static String replaceAsterisks(String s) {
        if(s == null || s.length() == 0)
            throw new IllegalArgumentException("invalid input");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '*') {
                if(s.charAt(i - 1) == '\\') {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append('*');
                } else if ((i + 1) < s.length() && Character.isAlphabetic(s.charAt(i + 1)))
                    sb.append("<b>");
                else if (Character.isAlphabetic(s.charAt(i - 1)))
                    sb.append("</b>");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}

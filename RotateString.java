/**

 Rotate the given string "s"

 */
public class RotateString {

    public static void main(String[] args) {
        rotateString("Codinggame");
    }

    private static void rotateString(String s) {
        if(s == null || s.length() == 0) return;

        for(int i = 0; i < s.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            for(int k = s.length() - i; k < s.length(); ++k) {
                sb.append(s.charAt(k));
            }
            sb.append(s.substring(0,s.length() - i));
            System.out.println(sb.toString());
        }
        System.out.println(s);
    }

}

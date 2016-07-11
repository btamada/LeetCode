/**

 Interlace 2 given strings

 */
public class InterlaceStrings {

    public static void main(String[] args) {
        String s1 = "acegikmoqsuwy";
        String s2 = "bdfhjlnprtvxz";
        System.out.println(interlaceStrings(s1,s2));
    }

    private static String interlaceStrings(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            throw new IllegalArgumentException("invalid input");
        StringBuilder sb = new StringBuilder();
        String bigString;
        String smallString;
        if(s1.length() > s2.length()) {
            bigString = s1;
            smallString = s2;
        } else {
            bigString = s2;
            smallString = s1;
        }
        int lastIndex = 0;
        int i;
        for(i = 0; i < smallString.length(); ++i) {
            sb.append(smallString.charAt(i));
            sb.append(bigString.charAt(i));
            lastIndex = i;
        }
        sb.append(bigString.substring(i));
        return sb.toString();
    }

}

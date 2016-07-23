/**
 * Determine if the given string is a safe password
 */
public class SafePassword {

    public static void main(String[] args) {
        System.out.println(isSafePassword("Abcdefg1"));
    }

    private static boolean isSafePassword(String s) {
        if(s == null || s.length() < 8) return false;
        boolean hasDigit = false;
        boolean hasLowerCaseLetter = false;
        boolean hasUpperCaseLetter = false;
        for(int i = 0; i < s.length(); ++i) {
            if(Character.isLowerCase(s.charAt(i))) hasLowerCaseLetter = true;
            if(Character.isUpperCase(s.charAt(i))) hasUpperCaseLetter = true;
            if(Character.isDigit(s.charAt(i))) hasDigit = true;
        }
        return hasDigit && hasLowerCaseLetter && hasUpperCaseLetter;
    }

}

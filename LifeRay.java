import java.util.Stack;

/**
 * Check if a string of parenthesis is balanced
 */
public class LifeRay {

    public static void main(String[] args) {
        System.out.println(balancedParenthesis("((()))"));
    }

    private static boolean balancedParenthesis(String str) {
        if(str == null || str.length() == 0) return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else if (!stack.isEmpty() && str.charAt(i) == ')')
                stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }

}

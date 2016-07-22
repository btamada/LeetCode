import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Rotate a number k places
 */
public class RotateInteger {

    public static void main(String[] args) {
        System.out.println(rotateNum(123456,2));
    }

    private static int rotateNum(int n, int k) {
        if(n <= 0) throw new IllegalArgumentException("invalid input");
        Deque<Integer> deque = new LinkedList<>();
        while(n > 0 && k-->0) {
            int mod = n % 10;
            deque.addFirst(mod);
            n /= 10;
        }
        Stack<Integer> stack = new Stack<>();
        while(n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        while(!stack.isEmpty()) {
            deque.addLast(stack.pop());
        }
        int pow = 0;
        int rotatedNum = 0;
        while(!deque.isEmpty()) {
            rotatedNum += (int)Math.pow(10,pow++) * deque.pollLast();
        }
        return rotatedNum;
    }

}

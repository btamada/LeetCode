import java.util.Random;

/**

 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 */
public class GuessNumberHigherOrLowerII {

    public static void main(String[] args) {
        System.out.println(guessNumberHigherOrLowerII(10));
    }

    private static int guessNumberHigherOrLowerII(int n) {
        if(n <= 0) throw new IllegalArgumentException("invalid input");
        int guess = 0, start = 0, totalAmt = 0;
        int end = n;
        int ans = new Random().nextInt(10) + 1;
        while(start < end) {
            guess = start + (end - start) / 2;
            if(guess == ans) return totalAmt;
            else if(guess < ans) end = guess - 1;
            else if(guess > ans) start = guess + 1;
            totalAmt += guess;
        }
        return totalAmt;
    }

}

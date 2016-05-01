import java.util.Scanner;

/**
 *
 * Write an algorithm that keeps track of the current average if your program
 * is taking in an endless amount of data as its input.
 *
 */
public class MovingAverageInfiniteInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double currAverage = 0.0;
        int totalNums = 0;
        double totalSoFar = 0.0;

        while(sc.hasNextDouble()) {
            ++totalNums;
            totalSoFar += sc.nextDouble();
            currAverage = totalSoFar / totalNums;
            System.out.println(currAverage);
        }
    }
}

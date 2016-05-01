/**
 *
 * Write an algorithm that keeps track of the current average if your program
 * is taking in an endless amount of data as its input.
 *
 */
public class MovingAverage {

    public static void main(String[] args) {
        double[] nums = {2.0,1.5,3.4,3.2,2.2,1.5,0.6,4.7,4.3,2.0,5.5,1.9,5.0,6.4,3.3};
        movingAverage(nums);
    }

    static void movingAverage(double[] nums) {
        if(nums == null || nums.length == 0) return;
        double currAverage = 0.0;
        double runningTotal = 0.0;
        int totalNums = 0;
        for(int i = 0; i < nums.length; i++) {
            ++totalNums;
            runningTotal += nums[i];
            currAverage = runningTotal / totalNums;
            System.out.println("Current Average: " + currAverage);
            if(totalNums != nums.length) currAverage = 0.0;
        }
        System.out.println("The total numbers counted are: " + totalNums);
        System.out.println("The last average found was: " + currAverage);
    }

}

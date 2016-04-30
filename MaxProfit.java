/**
 *
 * Phone screen question asked by Blend Labs.
 *
 * Given an integer array of car prices and the indices of the array representing
 * the times of the day, find the max profit you can make if you can only buy once
 * and sell once.
 *
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1000,1100,1150,1200,1250,1275,1300,800,1000};
        System.out.println(maxProfit(prices));
    }

    // Time: O(n)
    // Space: O(1)
    static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return -1;
        int currLowest = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < currLowest) currLowest = prices[i];
            int diff = prices[i] - currLowest;
            if(diff > maxProfit) maxProfit = diff;
        }
        return maxProfit;
    }

}

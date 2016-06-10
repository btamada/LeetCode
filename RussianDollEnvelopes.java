import java.util.Arrays;

/**

 You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(maxEnvelopes(envelopes));
    }

    /**
     *  Algorithm Design:
     *  - Create a new list of tuples
     *  - Iterate through the original list of tuples
     *  - Add the first tuple into the new list
     *  - For each subsequent tuple do binary search O (log n), checking the width and height of tuples
     *  that are already in the new list
     *  - Only add the new tuple if both (w,h) are less than or greater than existing tuples
     *  - Return the size of the list with the most tuples inside of it
     */
    public static int maxEnvelopes(int[][] envelopes) {
        // sort the array by the widths
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int max = 0;
        int dp [] = new int [envelopes.length];

        // iterate through the arrays using DP to descend through heights
        for(int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}

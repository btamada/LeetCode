import java.util.*;

/**

 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]

 */
public class FindKPairsSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        List<int[]> res = kSmallestPairs(nums1, nums2, 4);
        for (int[] a : res) {
            for (Integer n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    private static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            throw new IllegalArgumentException("invalid input");
        List<int[]> res = new ArrayList<>();

        // find all pairs and add to the list
        for(int i = 0; i < nums1.length; ++i) {
            for(int p = 0; p < nums2.length; ++p) {
                int[] tmp = new int[2];
                tmp[0] = nums1[i];
                tmp[1] = nums2[p];
                res.add(tmp);
            }
        }

        // sort the pairs
        Collections.sort(res, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // return the first k pairs or the whole list
        if (k < res.size())
            res = res.subList(0,k);

        return res;
    }

}

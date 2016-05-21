import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to num2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that
 you cannot load all elements into the memory at once?


 */
public class IntersectionArraysII {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        for(int n : intersection(nums1,nums2)) System.out.print(n + " ");
    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            if(nums1.length == 0) return nums1;
            if(nums2.length == 0) return nums2;
        }

        // find out which of the 2 arrays is longer
        int[] largest = null;
        int[] smallest = null;
        int[] result = null;

        if(nums1.length > nums2.length) {
            largest = nums1;
            smallest = nums2;
        } else if (nums2.length > nums1.length) {
            largest = nums2;
            smallest = nums1;
        } else {
            largest = nums1;
            smallest = nums2;
        }

        int resCtr = 0;

        // insert the numbers of the larger array into a hash map
        Map<Integer,Integer> map = new HashMap<>();

        // hold the integers that are in both arrays
        List<Integer> holder = new ArrayList<>();

        for(int i = 0; i < largest.length; i++) {
            if(map.containsKey(largest[i])) {
                int val = map.get(largest[i]);
                map.put(largest[i], ++val);
            } else {
                map.put(largest[i],1);
            }
        }

        // iterate through the smallest array
        for(int i = 0; i < smallest.length; i++) {
            if(map.containsKey(smallest[i])) {
                int val = map.get(smallest[i]);
                if(val > 0) {
                    ++resCtr;
                    holder.add(smallest[i]);
                    map.put(smallest[i], --val);
                }
            }
        }

        result = new int[resCtr];

        for(int i = 0; i < holder.size(); i++) {
            result[i] = holder.get(i);
        }

        return result;
    }

}

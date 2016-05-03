import java.util.*;
import java.util.stream.Stream;

/**

 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,4,4,4,4,4};
        List<Integer> result = topKFrequent(nums, 3);
        for(Integer i : result) System.out.println(i);
    }

    static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return null;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        // O(m), where m is the number of unique integers
        // put frequency of integers into a hashmap
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i],++val);
            } else {
                map.put(nums[i],1);
            }
        }

        map = sortByValue(map);

        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            result.add(ent.getKey());
            System.out.println(ent);
        }

        return result.subList(0,k);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue( Map<K, V> map )
    {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();

        st.sorted( Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEachOrdered( e -> result.put(e.getKey(), e.getValue()) );

        return result;
    }

}

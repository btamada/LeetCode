import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4,5,6,7,8}));
    }

    static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(Integer i : nums) {
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

}

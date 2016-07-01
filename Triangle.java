import java.util.Arrays;

/**

 Triangle Rules:
    a + b > c
    b + c > a
    a + c > b

    Given intergers a, b, and c determine if you can form a triangle.

 */
public class Triangle {

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        System.out.println(findAllTriangles(nums));
    }

    private static boolean isTriangle(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return false;
        if(a + b > c && b + c > a && a + c > b) return true;
        return false;
    }

    private static int findAllTriangles(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int k = i;
            System.out.println("i == " + i);
            for(int j = i; j < nums.length; j++) {
                while(nums.length > k && nums[i] + nums[j] > nums[k]) {
                    ++k;
                    System.out.println("k == " + k);
                }
                System.out.println("j == " + j);
                ans += k - j;
            }
        }
        return ans;
    }

}

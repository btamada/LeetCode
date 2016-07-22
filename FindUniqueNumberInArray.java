/**
 * Find the unique number in an array
 */
public class FindUniqueNumberInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,3,2,1};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("invalid input");
        int uniqueNum = 0;
        for(int i = 0; i < arr.length; i++) {
            uniqueNum ^= arr[i];
        }
        return uniqueNum;
    }

}

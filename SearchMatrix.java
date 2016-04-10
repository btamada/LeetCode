/**
 *
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 *
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50},
        };

        System.out.println(searchMatrix(matrix,30));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) throw new IllegalArgumentException("Invalid input");

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(matrix[i][matrix[i].length-1] < target) continue;
                else {
                    if(matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }

}

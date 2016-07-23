/**
 * Rotate a matrix 90 degrees clockwise
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        print(rotateMatrix(matrix));
    }

    private static void print(int[][] matrix) {
        for(int[] row : matrix) {
            for(Integer n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) throw new IllegalArgumentException("invalid input");
        int row = 0;
        int col = matrix[0].length - 1;
        int tmp1;
        int tmp2;
        while(row <= col) {
            int tmpRow = row;
            int tmpCol = col;
            while(tmpRow < col && tmpCol > row) {
                tmp1 = matrix[tmpRow][col];
                matrix[tmpRow][col] = matrix[row][tmpRow];
                tmp2 = matrix[col][tmpCol];
                matrix[col][tmpCol] = tmp1;
                tmp1 = matrix[tmpCol][row];
                matrix[tmpCol][row] = tmp2;
                matrix[row][tmpRow] = tmp1;
                ++tmpRow;
                --tmpCol;
            }
            ++row;
            --col;
        }
        return matrix;
    }

}

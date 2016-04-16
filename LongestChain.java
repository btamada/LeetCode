import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *  Problem Statement:
 *  Write a program that returns the length of the longest
 *  chain of consecutive numbers in a grid of natural numbers.
 *
 *  Example:
 *  [0, 1, 4]
 *  [2, 3, 5]
 *  [8, 7, 6]
 *
 *  Longest chain is [4, 5, 6, 7, 8] with length 5.
 *
 *  [0, 2]
 *  [3, 1]
 *  Longest chain is [1, 2] with length 2.
 *
 *  *HINT* There is a O(n log(n) solution and a O(n) solution, where n is
 *  the number of elements in the matrix.
 *
 */
public class LongestChain {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0,1,4},
                {2,3,5},
                {8,7,6},
        };

        int[][] matrix2 = {
                {0, 2},
                {3, 1}
        };

        int[][] matrix3 = {
            {0, 3, 2},
            {3, 0, 1},
            {2, 1, 0}
        };

        System.out.println(" with length " + longestChain(matrix3));
    }

    /**
     *
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     *
     * Algorithm Design
     *  Search through the matrix each element at a time
     *      For each element check its neighbors
     *          if the neighbor is exactly one bigger then move to that element
     *              Increment the longestChain counter by 1
     *              Keep checking each elements neighbors and moving to them until we cannot go anymore
     *  return longestChain
     *
     * @param matrix - the matrix to search through
     * @return - the longest chain of elements in the matrix
     */
    static int longestChain(int[][] matrix) {
        int longestChainLen = 1;
        String longestChain = "";

        // O(N)
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                String tempLongestChain = "[";

                // get the current element
                tempLongestChain += matrix[i][j] + ", ";

                // get the neighbors of the current element
                HashMap<Integer,String> neighbors = findNeighbors(matrix, i, j);
                Set<Integer> myKeys = neighbors.keySet();
                //System.out.print("element: " + matrix[i][j] + " ");
                //System.out.print("neighbors: ");

                // check if the current element has any valid neighbors
                if(!myKeys.isEmpty()) {
                    int tempLongestChainLen = 2;
                    int row = 0;
                    int col = 0;

                    // get the neighbor
                    for(Integer k : myKeys) {
                        tempLongestChain += k + ", ";
                        String val = neighbors.get(k);
                        String[] pos = val.split(",");
                        row = Integer.parseInt(pos[0]);
                        col = Integer.parseInt(pos[1]);
                    }

                    int nrow = row;
                    int ncol = col;

                    // check for more neighbors
                    while(!findNeighbors(matrix, nrow, ncol).isEmpty()) {

                        // found another neighbor so increment
                        ++tempLongestChainLen;

                        // get the neighbor's neighbor
                        HashMap<Integer,String> nNeighbors = findNeighbors(matrix, nrow, ncol);
                        Set<Integer> nKeys = nNeighbors.keySet();
                        int trow = 0;
                        int tcol = 0;
                        for(Integer nk : nKeys) {
                            tempLongestChain += nk + ", ";
                            String nval = nNeighbors.get(nk);
                            String[] npos = nval.split(",");
                            trow = Integer.parseInt(npos[0]);
                            tcol = Integer.parseInt(npos[1]);
                        }
                        nrow = trow;
                        ncol = tcol;
                    }

                    // update current longest chain if smaller
                    if(longestChainLen < tempLongestChainLen) {
                        longestChainLen = tempLongestChainLen;
                        longestChain = tempLongestChain.substring(0,tempLongestChain.length() - 2) + "]";
                    }

                } // done searching for all of the current element's neighbors

                //System.out.println();

            } // iterate to next element in the matrix

        } // done searching through the entire matrix

        System.out.print("Longest chain is " + longestChain);

        return longestChainLen;
    }

    // O(logn) - adding elements into a binary tree
    static HashMap<Integer, String> findNeighbors(int[][] matrix, int row, int col) {
        HashMap<Integer, String> neighbors = new HashMap<>();

        // check first column
        if (col == 0) {
            if (row == 0) { // upper-left corner
                // check right neighbor
                if (matrix[row][col + 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
                // check bottom neighbor
                if (matrix[row + 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
            } else if (row == matrix.length - 1) { // bottom-left corner
                // check top neighbor
                if (matrix[row - 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
                // check right neighbor
                if (matrix[row][col + 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
            } else { // somewhere in the middle
                // check top neighbor
                if (matrix[row - 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
                // check right neighbor
                if (matrix[row][col + 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
                // check bottom neighbor
                if (matrix[row + 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
            }
        }

        // check last column
        else if(col == matrix.length - 1) {
            if(row == 0) { // upper right corner
                // check left neighbor
                if (matrix[row][col - 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
                // check bottom neighbor
                if (matrix[row + 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
            } else if (row == matrix.length - 1) { // bottom right corner
                // check left neighbor
                if (matrix[row][col - 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
                // check top neighbor
                if (matrix[row - 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
            } else { // somewhere in the middle
                // check top neighbor
                if (matrix[row - 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
                // check left neighbor
                if (matrix[row][col - 1] == matrix[row][col] + 1)
                    neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
                // check bottom neighbor
                if (matrix[row + 1][col] == matrix[row][col] + 1)
                    neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
            }
        }

        // first row
        else if(col != 0 && col != matrix.length - 1 && row == 0) {
            // check left neighbor
            if (matrix[row][col - 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
            // check right neighbor
            if (matrix[row][col + 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
            // check bottom neighbor
            if (matrix[row + 1][col] == matrix[row][col] + 1)
                neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
        }

        // last row
        else if(col != 0 && col != matrix.length - 1 && row == matrix.length - 1) {
            // check left neighbor
            if (matrix[row][col - 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
            // check right neighbor
            if (matrix[row][col + 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
            // check top neighbor
            if (matrix[row - 1][col] == matrix[row][col] + 1)
                neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
        }

        // in the middle somewhere
        else {
            // check left neighbor
            if (matrix[row][col - 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col - 1], row + "," + (col - 1));
            // check right neighbor
            if (matrix[row][col + 1] == matrix[row][col] + 1)
                neighbors.put(matrix[row][col + 1], row + "," + (col + 1));
            // check top neighbor
            if (matrix[row - 1][col] == matrix[row][col] + 1)
                neighbors.put(matrix[row - 1][col], (row - 1) + "," + col);
            // check bottom neighbor
            if (matrix[row + 1][col] == matrix[row][col] + 1)
                neighbors.put(matrix[row + 1][col], (row + 1) + "," + col);
        }

        return neighbors;
    }



}

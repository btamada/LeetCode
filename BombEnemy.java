/**

 We have a 2D grid. Each cell is either a wall, an enemy or empty.

 For example (0-empty, X-enemy, Y-wall):

 0 X 0 0
 X 0 Y X
 0 X 0 0

 You have one bomb and you want to kill as many enemies as possible with it.
 The bomb will kill all the enemies in the same row and column from the planted point until it hits the wall
 since the wall is too strong to be destroyed.
 Given such a grid, return the maximum enemies you can kill with one bomb.
 Note that you can only put the bomb at empty cell.
 In the example, if you put a bomb at (1,1) you will kill 3 enemies which is the best you can get.
 You can not kill the guy behind the wall at (1,3).

 */
public class BombEnemy {

    public static void main(String[] args) {
        char[][] grid = {
            {'0', 'X', '0', '0'},
            {'X', '0', 'Y', 'X'},
            {'0', 'X', '0', '0'}
        };
        System.out.println(bombEnemy(grid));
    }

    /*
        Algorithm Design:
        - For each '0' in the grid place the bomb
            - move along the column until you either hit a wall ('Y') or the end of the column
            - move along the row until you either hit a wall ('Y') or the end of the row
            - keep a counter of how many enemies you kill as you iterate through each row/col
            - use Math.max() to compare the maxEnemiesKilled with the running total of currEnemiesKilled
                - put the result (the max of the two) into maxEnemiesKilled variable
        - return maxEnemiesKilled
     */
    private static int bombEnemy(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxEnemiesKilled = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int k = 0; k < grid[0].length; k++) {

                // found an empty cell
                if(grid[i][k] == '0') {

                    // keep track of number of enemies killed in this iteration
                    int currEnemiesKilled = 0;

                    // set empty space to 'B' for bomb
                    grid[i][k] = 'B';

                    // search through row and skip 'B' elements
                    currEnemiesKilled += searchRow(grid,i,k);

                    // search through col and skip 'B' elements
                    currEnemiesKilled += searchCol(grid,i,k);

                    // update the maximum enemies killed
                    maxEnemiesKilled = Math.max(currEnemiesKilled,maxEnemiesKilled);
                }
            }
        }
        return maxEnemiesKilled;
    }

    private static int searchRow(char[][] grid, int rowNum, int colNum) {

        int numEnemiesKilled = 0;

        return numEnemiesKilled;
    }

    private static int searchCol(char[][] grid, int rowNum, int colNum) {

        int numEnemiesKilled = 0;

        return numEnemiesKilled;
    }

}

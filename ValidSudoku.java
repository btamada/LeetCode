import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 *
 * Check for letters
 * Check each individual 3x3 box
 *
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','1','.','.','.','3','.','.'},
                {'.','.','4','.','.','.','1','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','8','.','.','.','.'},
                {'.','1','.','.','2','.','.','.','.'},
                {'.','.','.','.','.','.','6','3','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'5','8','.','.','.','.','4','.','.'},
                {'.','5','.','.','4','.','.','.','8'}
        };

        System.out.println(isValidSudoku(board));
    }

    /**
     *  i == 0, j == 0
     *  i == 0, j == 3
     *  i == 0, j == 6
     *
     *  i == 3, j == 0
     *  i == 3, j == 3
     *  i == 3, j == 6
     *
     *  i == 6, j == 0
     *  i == 6, j == 3
     *  i == 6, j == 6
     */
    static boolean isValidBox(char[][] board) {
        int len = board.length;
        int start = 0;
        int mid = start + 3;
        int last = mid + 3;
        int counter = 3;

        Set<Character> distNums = new HashSet<>();

        for(int a = start; a < len; a+=3) {
            distNums.clear();
            System.out.println(distNums.size());
            for (int i = a; i < counter; i++) {
                for (int j = 0; j < mid; j++) {
                    if (board[i][j] == '.') continue;
                    System.out.println("i: " + i);
                    System.out.println(" j: " + j);
                    System.out.println(" " + board[i][j]);
                    if (distNums.contains(board[i][j])) return false;
                    else distNums.add(board[i][j]);
                }
            }
            System.out.println(distNums.size());

            distNums.clear();
            System.out.println(distNums.size());
            for (int i = a; i < counter; i++) {
                for (int j = mid; j < last; j++) {
                    if (board[i][j] == '.') continue;
                    System.out.println("i: " + i);
                    System.out.println(" j: " + j);
                    System.out.println(" " + board[i][j]);
                    if (distNums.contains(board[i][j])) return false;
                    else distNums.add(board[i][j]);
                }
            }
            System.out.println(distNums.size());

            distNums.clear();
            System.out.println(distNums.size());
            for (int i = a; i < counter; i++) {
                for (int j = last; j < len; j++) {
                    if (board[i][j] == '.') continue;
                    System.out.println("i: " + i);
                    System.out.println(" j: " + j);
                    System.out.println(" " + board[i][j]);
                    if (distNums.contains(board[i][j])) return false;
                    else distNums.add(board[i][j]);
                }
            }
            System.out.println(distNums.size());
            counter += 3;
        }

        return true;
    }

    static boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;

        for(int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            // check if row is valid
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                if(rowSet.contains(board[i][j]) || board[i][j] - '1' < 0 || board[i][j] - '1' > 8) return false;
                else rowSet.add(board[i][j]);
            }

            // check if the column is valid
            for(int k = 0; k < board[0].length; k++) {
                if(board[k][i] == '.') continue;
                if(colSet.contains(board[k][i]) || board[k][i] - '1' < 0 || board[k][i] - '1' > 8) return false;
                else colSet.add(board[k][i]);
            }
        }

        return isValidBox(board);
    }

}

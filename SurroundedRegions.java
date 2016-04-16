import java.util.Queue;
import java.util.LinkedList;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'},
        };
        solve(board);
    }

    static void solve(char[][] board) {
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                if(board[i-1][j] == 'O' || board[i][j+1] == 'O') continue;
                if(j == board.length - 2 && board[i-1][j] == 'X' && board[i][j+1] == 'X' && board[i][j-1] != 'O') {
                    int counter = j;
                    while(counter >= 1) {
                        board[i][counter] = 'X';
                        --counter;
                    }
                }
            }
        }

        for(int i = 0; i < board[0].length; i++) {
            for(char c : board[i]) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}

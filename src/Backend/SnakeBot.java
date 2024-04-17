package Backend;
import java.util.ArrayList;
import java.util.que
public class SnakeBot {


    private static ArrayList<Integer> safeMoves = new ArrayList<>();

    static {
        safeMoves.add(87); // ASCII for 'W' (Up)
        safeMoves.add(83); // ASCII for 'S' (Down)
        safeMoves.add(68); // ASCII for 'D' (Right)
        safeMoves.add(65); // ASCII for 'A' (Left)
    }

    public static void checkAndRemoveMoves(int[][] board, int[] head) {
        int x = head[0];
        int y = head[1];

        // Check Up (W)
        if (x > 0 && board[x-1][y] == 3) {
            safeMoves.remove(Integer.valueOf(87)); // Remove 'W' from the list
        }
        // Check Down (S)
        if (x < board.length - 1 && board[x+1][y] == 3) {
            safeMoves.remove(Integer.valueOf(83)); // Remove 'S' from the list
        }
        // Check Right (D)
        if (y < board[0].length - 1 && board[x][y+1] == 3) {
            safeMoves.remove(Integer.valueOf(68)); // Remove 'D' from the list
        }
        // Check Left (A)
        if (y > 0 && board[x][y-1] == 3) {
            safeMoves.remove(Integer.valueOf(65)); // Remove 'A' from the list
        }
        }
        
    }



    public static void main(String args[]){

    }
}
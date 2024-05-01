package Backend;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
public class Board{
    private int time;
    private static int index = 1;
    public static int[][] board;
    public static void arrprint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public static int[][] createBoard(int size) {
        int[][] board = new int[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        int half = size/2;
        board[half][half] = 1;
        return board;
    }
    public static int[][] Boardgetter(){
        return board;
    }
    public static void foodGen(int[][] board){
        Random random = new Random();
        int randomInt1;
        int randomInt2;
        do {
            randomInt1 = random.nextInt(board.length);
            randomInt2 = random.nextInt(board.length);
        } while (board[randomInt1][randomInt2] != 0);

        board[randomInt1][randomInt2] = 1;
    }
    public static void main(String[]args) throws IOException {
    }

}

package Backend;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends TimerTask{
    private int time;
    private int[][] board;

    public static void arrprint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }


    public static int[][] board(int size) {
        int[][] board = new int[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static void foodGen(int[][] board){
        Random random = new Random();
        int randomInt1;
        int randomInt2;
        do {
            randomInt1 = random.nextInt(board.length);
            randomInt2 = random.nextInt(board.length);
        } while (board[randomInt1][randomInt2] == 1);
        board[randomInt1][randomInt2] = 1;
        random.close();


    }
    public static void main(String[]args) throws IOException {
        Board gameBoard = new Board(6);
    }

}

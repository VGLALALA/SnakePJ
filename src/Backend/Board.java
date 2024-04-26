package Backend;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends TimerTask{
    private int time;
    private static int index = 1;
    public static int[][] board;
    public static int[][] foodCoords = new int[10][2];
    static{
        foodCoords[index][0] = 6;
        foodCoords[index][1] = 6;
    }
    public Board(int boardsize) {
        time = 0;
        Timer clock = new Timer();
        board = new int[boardsize][boardsize];
        foodCoords = new int[0][2];
        clock.scheduleAtFixedRate(this, 0, 2000);
    }
    @Override
    public void run() {
        time++;
        System.out.println(time);
        foodGen(board);
    }
    public static void arrprint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
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
        foodCoords[index][0] = randomInt1;
        foodCoords[index][1] = randomInt2;
        index++;

        board[randomInt1][randomInt2] = 1;
    }
    public static void main(String[]args) throws IOException {
    }

}

package Backend;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
public class Main extends TimerTask{
    private int time;
    private static int boardsize = InputTaker.sizeGetter();
    private int[][] board = Board.board(boardsize);
    public Main(int boardsize) {
        time = 0;
        Timer clock = new Timer();
        board = new int[boardsize][boardsize];
        clock.scheduleAtFixedRate(this, 0, 2000);
    }
    @Override
    public void run() {
        time++;
        System.out.println(time);
        Board.foodGen(board);
        Board.arrprint(board);
    }
    public static void main(String[]args){

    }
}
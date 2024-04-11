package Backend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
public class Main extends TimerTask implements KeyListener {
    private JFrame frame;
    private int time;
    private int key = 87;
    public static int[][] board;
    public static int boardSize = InputTaker.sizeGetter();
    public static JLabel[][] frames = Main.createLabelGrid(boardSize, boardSize);
    public Main() {
        board = Board.board(boardSize);
        frame = new JFrame();
        frame.setTitle("BattleSnake");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel(new GridLayout(boardSize,boardSize));
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JLabel label = new JLabel(""+board[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Serif", Font.PLAIN, 35));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                panel.add(label);
                frames[i][j] = label;
            }
        }
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        time = 0;
        Timer clock = new Timer();
        clock.scheduleAtFixedRate(this, 0, 2000);
    }
    private static JLabel[][] createLabelGrid(int rows, int cols) {
        JLabel[][] labels = new JLabel[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                labels[i][j] = new JLabel(); // Initialize each JLabel
            }
        }
        return labels;
    }
    @Override
    public void run() {
        time++;
        board = SnakeAPI.doMove(board,key,true);
        updateBoard();
        System.out.println(time);
        Board.foodGen(board);
        Board.arrprint(board);
    }
    public static void updateBoard(){
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames.length; j++) {
                frames[i][j].setText(Integer.toString(board[i][j]));
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        board = SnakeAPI.doMove(board,key,true);
        Main.updateBoard();
        System.out.println(key);
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public static void main(String[] args) {
        Main backendMain = new Main();
    }
}
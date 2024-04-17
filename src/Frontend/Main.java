package Frontend;
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
import Backend.Board;
import Backend.InputTaker;
import Backend.SnakeAPI;


public class Main extends TimerTask implements KeyListener {
    private JFrame frame;
    private JLabel hpLabel;
    private int time;
    private int key = 83;
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
                hpLabel = new JLabel(Integer.toString(100));
                hpLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                hpLabel.setFont(new Font("Serif", Font.PLAIN, 35));
                frame.getContentPane().add(hpLabel, BorderLayout.NORTH);
            }
        }
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        time = 0;
        Timer clock = new Timer();
        clock.scheduleAtFixedRate(this, 0, 500);
    }
    private static JLabel[][] createLabelGrid(int rows, int cols) {
        JLabel[][] labels = new JLabel[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                labels[i][j] = new JLabel();
            }
        }
        return labels;
    }

    public static int[][] getBoard() {
        return board;
    }
    @Override
    public void run() {
        time++;
        board = SnakeAPI.doMove(board,key,true);
        hpLabel.setText("HP: " + Observer.getHp(1));
        Observer.health -= 1;
        Observer.health2 -= 1;
        health2 -= 1;
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames.length; j++) {
                frames[i][j].setText(Integer.toString(board[i][j]));
            }
        }
        System.out.println(time);
        Board.foodGen(board);
        Board.arrprint(board);
    }

    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
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
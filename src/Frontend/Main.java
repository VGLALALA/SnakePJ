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
import Backend.Observer;
import Backend.SnakeAPI;
import Backend.SnakeBot;


public class Main extends TimerTask implements KeyListener {
    private JFrame frame;
    private JLabel hpLabel;
    private int time;
    private int key = 83;
    public static int[][] board;
    public static int boardSize;
    public static JLabel[][] frames = Main.createLabelGrid(boardSize, boardSize);
    public Main() {
        showInputDialog();
        board = Board.createBoard(boardSize);
        frame = new JFrame();
        frame.setTitle("BattleSnake");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel(new GridLayout(boardSize,boardSize));

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JLabel label = new JLabel();
                if(board[i][j] == 0){
                    label = new JLabel();
                    label.setText("");
                } else if (board[i][j] == 1) {
                    label = new JLabel("<html><div style='width: 30px; height: 30px; background-color: red;'></div></html>");
                    label.setText("");
                } else if (board[i][j] == 3) {
                    label = new JLabel("<html><div style='width: 30px; height: 30px; background-color: green;'></div></html>");
                    label.setText("");
                }

                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Serif", Font.PLAIN, 35));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                panel.add(label);
                frames[i][j] = label;
                hpLabel = new JLabel(Integer.toString(100));
                hpLabel.setHorizontalAlignment(SwingConstants.LEFT);
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
    private void showInputDialog() {
        JLabel messageLabel = new JLabel("Controls WASD, red boxes are food, orange is opponent, and green is you");
        String input = JOptionPane.showInputDialog(null, "Enter the board size:", "BattleSnake Setup", JOptionPane.QUESTION_MESSAGE);
        if (input != null) {
            try {
                int boardSize = Integer.parseInt(input);
                if (boardSize > 0) {
                    setupGame(boardSize);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid board size. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                    showInputDialog();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                showInputDialog();
            }
        }
        Object[] message = {
                messageLabel

        };
        JOptionPane.showMessageDialog(null, message, "BattleSnake Setup", JOptionPane.INFORMATION_MESSAGE);
    }
    private void setupGame(int boardSize) {
        Main.boardSize = boardSize;
        Main.board = board = Board.createBoard(boardSize);
        Main.frames = Main.createLabelGrid(boardSize, boardSize);
        frame = new JFrame();
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
        if (Math.random() <= 0.50) {
            Board.foodGen(board);
        }
        Board.arrprint(board);
        int key2 = SnakeBot.getRandomMove(board);
        board = SnakeAPI.doMove(board,key2,false);
        board = SnakeAPI.doMove(board,key,true);
        board = SnakeAPI.moveSnakes(board);
        hpLabel.setText("HP: " + Observer.health);
        Observer.health -= 3;
        Observer.health2 -= 3;
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames[i].length; j++) {
                int value = board[i][j];
                if (value == 0) {
                    frames[i][j].setText("");
                } else if (value == 1) {
                    frames[i][j].setText("<html><div style='width: 30px; height: 30px; background-color: red;'></div></html>");
                } else if (value == 3) {
                    frames[i][j].setText("<html><div style='width: 30px; height: 30px; background-color: green;'></div></html>");
                } else if (value == 4) {
                    frames[i][j].setText("<html><div style='width: 30px; height: 30px; background-color: orange;'></div></html>");
                } else {
                    frames[i][j].setText(Integer.toString(value));
                }
            }
        }
        int[] head = SnakeAPI.getHead();
        System.out.println(Arrays.toString(head));
        frames[head[0]][head[1]].setText("<html><div style='width: 30px; height: 30px; background-color: lime;'></div></html>");
        System.out.println(time);

    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 87 || e.getKeyCode() == 83 || e.getKeyCode() == 68 || e.getKeyCode() == 65) {
            key = e.getKeyCode();
            System.out.println(key);
        }
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public static void main(String[] args) {
        Main backendMain = new Main();
    }
}
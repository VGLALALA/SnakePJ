package Backend;
import javax.swing.*;
import java.awt.*;
public class Main {
    public int boardSize = 6;
    public Main(int[][] board) {
        setTitle("BattleSnake");
        setSize(2560, 1440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(boardSize));
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JLabel label = new JLabel(board[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Serif", Font.PLAIN, 35));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                panel.add(label);

            }
        }
        getContentPane().add(panel);

    }
    public static void main(String[]args){
        Main main = new Main(board);
        minesweeper.setVisible(true);
    }
}
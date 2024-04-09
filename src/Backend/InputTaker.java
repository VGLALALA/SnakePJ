import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;




public class InputTaker {
    public static HashMap<String,Integer> inputaker() throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Set Board Size: ");
        int boardsize = Integer.parseInt(br.readLine());
        map.put("boardsize",boardsize);
        return map;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:

                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                break;
        }
    }

    public static void main(String[] args) {
        new KeyListenerExample();
    }


}
package Backend;
import javax.swing.*;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputTaker implements KeyListener {
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        InputTaker listener = new InputTaker();
    }
    public static int sizeGetter() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What board size?: ");
        int size = myObj.nextInt();
        return size;
    }
}
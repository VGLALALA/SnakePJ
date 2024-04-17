package Backend;
import javax.swing.*;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputTaker  {


    public static void main(String[] args) {

    }
    public static int sizeGetter() {
        Scanner myObj = new Scanner(System.in);
        int size = 0;
        while (size < 5) {
            System.out.println("What board size?: ");
            int size = myObj.nextInt();
        }
        return size;
    }
}
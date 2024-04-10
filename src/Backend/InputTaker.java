package Backend;
import java.util.Scanner;

public class InputTaker {
        public static int sizeGetter() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What board size?: ");
        int size = myObj.nextInt();
        return size;
    }
}
package Backend;
import java.util.Arrays;
public class Observer {
    private static int[][] array1 = SnakeAPI.snake;
    private static int[][] array2 = SnakeAPI.snake2;
    public static int health = 100;
    public static int health2 = 100;
    private int[][] board = Board.board;
    private static boolean ss1 = false;
    private static boolean ss2 = false;
    public static void sharesSpace(int[][] array1,int[][] array2) {
        for (int i = 0; i < array1.length - 1; i++) {
            int[] a = array1[i];
            if (array2[array2.length-1] == a || array1[array1.length-1] == a){
                ss2 = true;
            }
        }
        for (int i = 0; i < array2.length - 1; i++) {
            int[] a = array2[i];
            if (array1[array1.length-1] == a || array2[array2.length-1] == a) {
                ss1 = true;
            }
        }
        int[] head2 = array2[array2.length-1];
        int[] head = array1[array1.length-1];
        if(head[0] > 9 || head[0] < 0 || head[1] > 9 || head[1] < 0){
            ss1 = true;
            System.out.println("HI");
        } else if (head2[0] > 9 || head2[0] < 0 || head2[1] > 9 || head2[1] < 0) {
            ss2 = true;
        }
        if (health < 1){
            ss1 = true;
        }
        if (health2 < 1){
            ss2 = true;
        }
        if (ss1 && ss2){
            System.out.println("TIE");
            System.exit(0);
        } else if (ss1) {
            System.out.println("YOU LOSE");
            System.exit(0);
        } else if (ss2) {
            System.out.println("YOU WIN");
            System.exit(0);
        }
        System.out.println("YOU");
        System.out.println(ss1);
    }
    public static void main(String[] args) {

    }
}
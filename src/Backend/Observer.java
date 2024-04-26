package Backend;
import java.util.Arrays;
public class Observer {
    private static int[][] array1 = SnakeAPI.snake;
    private static int[][] array2 = SnakeAPI.snake2;
    public static int health = 100;
    public static int health2 = 100;
    public static int[][] board = Board.board;
    private static boolean ss1 = false;
    private static boolean ss2 = false;
    public static int[] head2 = array2[array2.length-1];
    public static int[] head = array1[array1.length-1];
    public static void sharesSpace(int[][] array1,int[][] array2,int maxSize) {
        for (int i = 0; i < array1.length - 1; i++) {
            int[] a = array1[i];
            if (Arrays.equals(array1[array1.length - 1], a)) {
                ss1 = true;

            }
            if (Arrays.equals(array2[array2.length - 1], a)) {
                ss2 = true;
            System.out.println("DEATH BY OPP");
            }
        }
        for (int i = 0; i < array2.length - 1; i++) {
            int[] a = array2[i];
            if (Arrays.equals(array2[array2.length - 1], a)) {
                ss2 = true;
                System.out.println("DEATH BY SELF");
            }
            if (Arrays.equals(array1[array1.length - 1], a)) {
                ss1 = true;

            }
        }
        head = array1[array1.length-1];
        head2 = array2[array2.length-1];
        if(head[0] > maxSize || head[0] < 0 || head[1] > maxSize || head[1] < 0){
            ss1 = true;
            System.out.println("HI");
        } else if (head2[0] > maxSize || head2[0] < 0 || head2[1] > maxSize || head2[1] < 0) {
            ss2 = true;
        }
        if (health < 1){
            ss1 = true;
        }
        if (health2 < 1){
            ss2 = true;
        }
        if (Arrays.equals(head, head2)){
            if(array1.length < array2.length){
                ss1 = true;
                ss2 = false;
            } else if(array2.length < array1.length) {
                ss1 = false;
                ss2 = true;
            } else {
                ss1 = true;
                ss2 = true;
            }
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
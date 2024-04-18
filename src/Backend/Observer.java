package Backend;
public class Observer {
    private static int[][] array1 = SnakeAPI.snake;
    private static int[][] array2 = SnakeAPI.snake2;
    public int health = 100;
    public int health2 = 100;
    private int[][] board = Board.board;
    private boolean ss1 = false;
    private boolean ss2 = false;
    public static int sharesSpace() {
        for (int[][] a : array1){
            if (array2[array2.length-1] == array1){
                ss2 = true;
            }
        }
        for (int[][] a : array2){
            if (array1[array1.length-1] == a){
                ss1 = true;
            }
        }
        int[] head2 = array2[array2.length-1];
        int[] head = array1[array1.length-1];
        if(head[0] > 9 || head[0] < 0 || head[1] > 9 || head[1] < 0){
            ss1 = true;
        } else if (head2[0] > 9 || head2[0] < 0 || head2[1] > 9 || head2[1] < 0) {
            ss2 = true;
        }
        if (health < 1){
            ss1 = true;
        }
        if (health2 < 1){
            ss2 = true;
        }
    }
    public static void main(String[] args) {

    }
}
package Backend;
public class Observer {
    private static int[][] snake = SnakeAPI.snake;
    private static int[][] snake2 = SnakeAPI.snake2;
    private int health = Main.health;
    private int health2 = Main.health2;
    private int[][] board = Board.board;
    public static boolean inList(int[][] array1,int[] j) {
        for (int[] i: array){
            if (j == i){
                return true
            }
        }
        return false
    }
    public static boolean sharesSpace(int[][] array1, int[][] array2) {
        for (int[] i: array1){
            if(inList(array2,i)){
                return true
            }
        }
        return false
    }
    public static void main(String[] args) {

    }
}
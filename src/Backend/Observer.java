package Backend;
public class Observer {
    private static int[][] snake = SnakeAPI.snake;
    private static int[][] snake2 = SnakeAPI.snake2;
    private static int health = 100;
    private static int health2 = 100;
    private int[][] board = Board.board;
    public static int getHp(int i) {
        if (i == 1) {
            return health;
        } else {
            return health2;
        }
    }
    public static boolean inList(int[][] array1,int[] j) {
        for (int[] i: array){
            if (j == i){
                return true;
            }
        }
        return false;
    }
    public static boolean sharesSpace(int[][] array1, int[][] array2) {
        for (int[] i: array1){
            if(inList(array2,i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
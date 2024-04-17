package Backend;
public class Observer {
    private static int[][] snake = SnakeAPI.snake;
    private static int[][] snake2 = SnakeAPI.snake2;
    private int health = Main.health;
    private int health2 = Main.health2;
    private int[][] board = Board.board;
    public static int getHumanHealth(){
        return health;
    }
    public static int getBotHealth(){
        return health2;
    }
    public static boolean sharesSpace(int[][] array1, int[][] array2) {

    }
    public static int doMove(int health, int health2, int[][] snake, int[][] snake2) {

    }
    public static void main(String[] args) {

    }
}
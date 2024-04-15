package Backend;
public class Observer {
    private static int[][] snake = SnakeAPI.snake;
    private static int[][] snake2 = SnakeAPI.snake2;
    private int health = Main.health;
    private int health2 = Main.health2;
    private int[][] board = Board.board;
    public static boolean share(int[][] array1, int[][] array2) {
        Set<String> set = new HashSet<>();
        for (int[] arr : array1) {
            set.add(Arrays.toString(arr));
        }
        for (int[] arr : array2) {
            if (set.contains(Arrays.toString(arr))) {
                return true;
            }
        }
        return false;
    }
    public static int doMove(int health, int health2, int[][] snake, int[][] snake2) {

    }
    public static void main(String[] args) {

    }
}
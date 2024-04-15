package Backend;
public class Observer {
    private static int[][] snake1 = SnakeAPI.getValue("BODY")[0];
    private static int[][] snake2 = SnakeAPI.getValue("BODY")[1];
    private int health = SnakeAPI.health;
    private int health2 = SnakeAPI.health2;
    private int[] snake1head = snake1[0];
    private int[] snake2head = snake2[0];
    private int[][] board = Board.board;
    public static boolean snake1dead = false;
    public static boolean snake2dead = false;
    public static boolean IsCollide() {
        int x = snake2[0][0];
        int y = snake2[0][1];
        int ax = snake1[0][0];
        int ay = snake1[0][1];

        if (x == ax && y == ay){
            if(health > health2) {
                snake2dead = true;
            }else if(health < health2){
                snake1dead = true;
            }else{
                snake1dead = true;
                snake2dead = true;
            }
        }

        for(int i = 1; i < snake1.length; i++) {
            int newx = snake2[i][0];
            int newy = snake2[i][1];
            if(x == newx && y == newy){
                return true;
            }
        }
        return false;
    }
    public static void isDead() {
        if(health <= 0){
            snake1dead = true;
        }if(health2 <= 0){
            snake2dead = true;
        }
    }
    public static void main(String[]args){

    }

    }
}
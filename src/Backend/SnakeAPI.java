package Backend;
import java.lang.*;
import java.util.*;

public class SnakeAPI {
    private static int[][] snake  = {{1 , 1}};;
    private static int[][] snake2 = {{5 , 5}};
//    private static int snakelength = snake.length;
//    private static int snakelength2 = snake2.length;
    public static int[][] addX(int[][] myArray, int[] x) {
        List<int[]> arrList = new ArrayList<>(Arrays.asList(myArray));
        arrList.add(x);
        return arrList.toArray(new int[arrList.size()][2]);
    }
    public static int[][] removeFront(int[][] array) {
        if (array.length <= 1) {
            return new int[0][0];
        } else {
            int[][] result = new int[array.length - 1][];
            System.arraycopy(array, 1, result, 0, array.length - 1);
            return result;
        }
    }
    //online
//    public Object getValue(String condition) {
//
//        if (condition) {
//            return "A String";
//        } else {
//            return 42; // An Integer
//        }
//    }

    public static int[][] doMove(int[][] board,int key,boolean person) {
        int[] head;
        int[] head2;
        head = snake[snake.length-1];
        head2 = snake2[snake2.length-1];
        if (person) {
            if (key == 87) {
                snake = addX(snake, new int[]{head[0] - 1, head[1]});
            } else if (key == 83) {
                snake = addX(snake, new int[]{head[0] + 1, head[1]});

            } else if (key == 68) {
                snake = addX(snake, new int[]{head[0], head[1] + 1});
            } else if (key == 65) {
                snake = addX(snake, new int[]{head[0], head[1] - 1});
            }
        } else {

            if (key == 87) {
                snake2 = addX(snake, new int[]{head2[0], head2[1] + 1});
            } else if (key == 83) {
                snake2 = addX(snake, new int[]{head2[0], head2[1] - 1});
            } else if (key == 68) {
                snake2 = addX(snake, new int[]{head2[0] + 1, head2[1]});
            } else if (key == 65) {
                snake2 = addX(snake, new int[]{head2[0] - 1, head2[1]});
            }
        }
        head2 = snake2[snake2.length-1];
        head = snake[snake.length-1];
        if(head[0] > 9 || head[0] < 0 || head[1] > 9 || head[1] < 0){
            System.out.println("YOU LOSE!");
            System.exit(0);
        } else if (head2[0] > 9 || head2[0] < 0 || head2[1] > 9 || head2[1] < 0) {

        }
        if (board[head[0]][head[1]] != 1) {
            snake = removeFront(snake);
        }else{
            Main.health = 100;
            Main.health2 = 100;
        }
        System.out.println(Arrays.deepToString(snake));
        for (int i = 0; i < board.length;i++){
            for (int d = 0; d < board.length;d++){
                boolean isInSnake = false;
                for (int[] position : snake) {
                    if (position[0] == i && position[1] == d) {
                        isInSnake = true;
                        break;
                    }
                }
                if (board[i][d] != 3 && isInSnake) {
                    board[i][d] = 3;
                } else if (board[i][d] == 3 && !isInSnake) {
                    board[i][d] = 0;
                }

            }
        }
        return board;
    }
    public static void main(String[]args){

    }
}

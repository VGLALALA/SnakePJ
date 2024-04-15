package Backend;
import java.lang.*;
import java.util.*;

public class SnakeAPI {
    public static int[][] snake;
    public static int[][] snake2 = {{1,1}};
    public static int health = 100;
    public static int health2 = 100;
    public static int snakelength = snake.length;
    public static int snakelength2 = snake2.length;
    public DataWrapper getValue(String condition) {
        if (condition == "HEALTH") {
            return new DataWrapper(health,health2);
        } else if(condition == "LENGTH") {
            return new DataWrapper(snakelength,snakelength2);
        } else if (condition == "BODY") {
            return new DataWrapper(snake,snake2);
        }
    }
    public static int[][] addX(int[][] myArray, int[] x) {
        List<int[]> arrList = new ArrayList<>(Arrays.asList(myArray));
        arrList.add(x);
        return arrList.toArray(new int[arrList.size()][2]);
    }
    public static int[][] removeFront(int[][] array) {
        if (array.length <= 1) {
            return new int[0][0]; // If the array has only one or zero elements, return an empty array
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
        if (person) {
            head = snake[snake.length-1];
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
            head2 = snake2[snake2.length-1];
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
        removeFront(snake);
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
        System.out.println(snake);
        return board;
    }
    public static void main(String[]args){

    }
}

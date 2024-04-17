package Backend;
import java.lang.*;
import java.util.*;

public class SnakeAPI {
    private static int[][] snake  = {{0 , 0}};;
    private static int[][] snake2 = {{1,1}};
//    private static int snakelength = snake.length;
//    private static int snakelength2 = snake2.length;
    public static int[][] addX(int[][] myArray, int[] x) {
        List<int[]> arrList = new ArrayList<>(Arrays.asList(myArray));
        arrList.add(x);
        return arrList.toArray(new int[arrList.size()][2]);
    }

    public static int[][] removeFirstSubArray(int[][] originalArray) {

        // Create a new 2D array with one less sub-array
        int[][] newArray = new int[originalArray.length - 1][];

        // Copy sub-arrays from the original array, skipping the first sub-array
        for (int i = 1; i < originalArray.length; i++) {
            newArray[i - 1] = originalArray[i];
        }

        return newArray;
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
        head = snake[snake.length-1];
        if (board[head[0]][head[1]] != 1) {
            snake = removeFirstSubArray(snake);
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

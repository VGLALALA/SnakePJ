package Backend;
import java.lang.*;
import java.util.*;

public class SnakeAPI {
    private static int[][] snake = {{1,1}};
    public static int[][] addX(int[][] myArray, int[] x) {
        List<int[]> arrList = new ArrayList<>(Arrays.asList(myArray));
        arrList.add(x);
        return arrList.toArray(new int[arrList.size()][2]);
    }//onlineu

    public static int[][] doMove(int[][] board,int key,boolean person) {

        if (person){
            if (key == 87) {
                snake = addX(snake, new int[]{snake[0igt ][0], snake[0][1] + 1});
            } else if (key == 83) {
                snake = addX(snake, new int[]{snake[0][0], snake[0][1] - 1});
            } else if (key == 68) {
                snake = addX(snake, new int[]{snake[0][0] + 1, snake[0][1]});
            } else if (key == 65) {
                snake = addX(snake, new int[]{snake[0][0] - 1, snake[0][1]});
            }
        }
        for (int i = 0; i < snake.length;i++){
            board[snake[i][0]][snake[i][1]] = '●';
        }
        System.out.println(snake);
        return board;
    }
    public static void main(String[]args){

    }
}

package Backend;
import java.lang.*;
import java.util.*;

public class SnakeAPI {
    private static int[][] snake = [[1,1]];
    public static int[][] addX(int[][] myArray[], int[] x) {
        int i;
        List arrList = new ArrayList( Arrays.asList(myArray));
        arrList.add(x);
        myArray = arrList.toArray(myArray);
        return myArray;
    }
    public static int[][] doMove(int[][] board,int key,boolean person) {

        if (person){
            if(key == 87){
                snake = addX(snake, [snake[0],snake[1]+1]);
            } else if (key == 83) {
                snake = addX(snake, [snake[0],snake[1]-1]);
            } else if(key == 68){
                snake = addX(snake, [snake[0]+1,snake[1]]);
            } else if (key == 65) {
                snake = addX(snake, [snake[0]-1,snake[1]]);
            }
        }
        for (int i; i < snake.length;i++){
            board[snake[i][0]][snake[i][1]] = '●';
        }
        return board;
    }
    public static void main(String[]args){

    }
}

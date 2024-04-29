package Backend;
import java.util.*;

import Backend.Observer;
import Backend.SnakeAPI;



import java.util.ArrayList;

public class SnakeBot {
    private static Random random = new Random();
    public static int[][] board;
    private static int[][] foodCoords = Board.foodCoords;
    private static int[] botHead = SnakeAPI.snake2[SnakeAPI.snake2.length - 1];
    private static int[] humanHead = SnakeAPI.snake[SnakeAPI.snake.length - 1];
    private static int[][] humanBody = SnakeAPI.snake;
    private static int[][] botBody = SnakeAPI.snake2;
    private static int OppHealth = Observer.health;
    private static int BotHealth = Observer.health2;
    private static ArrayList<Integer> safeMoves = new ArrayList<>();


    static {
        safeMoves.add(87);
        safeMoves.add(83);
        safeMoves.add(68);
        safeMoves.add(65);
    }
    public static int getRandomMove(int[][] b) {
        board = b;
        int[] target;
        resetSafeMoves();
        foodCoords = Board.foodCoords;
        botHead = SnakeAPI.snake2[SnakeAPI.snake2.length - 1];
        humanHead = SnakeAPI.snake[SnakeAPI.snake.length - 1];
        humanBody = SnakeAPI.snake;
        botBody = SnakeAPI.snake2;
        OppHealth = Observer.health;
        BotHealth = Observer.health2;
        if (botBody.length <= humanBody.length) {
            target = findClosestCoord(foodCoords, botHead);
        } else {
            target = humanHead;
        }
        System.out.println("TARGET");
        System.out.println(Arrays.toString(target));
        checkAndRemoveUnsafeMoves();
        System.out.println("SAFE MOVES");
        System.out.println(safeMoves);
        System.out.println("Head: ");
        System.out.println(Arrays.toString(botHead));
        int n = moveTowardsTarget(target);
        System.out.println("MOVE CHOSEN: ");
        System.out.println(n);
        return n;
    }
    private static void resetSafeMoves() {
        safeMoves.clear();
        safeMoves.add(87);
        safeMoves.add(83);
        safeMoves.add(68);
        safeMoves.add(65);
    }
    private static void checkAndRemoveUnsafeMoves() {
        Board.arrprint(board);
        List<Integer> movesToRemove = new ArrayList<>();
        for (int move : safeMoves) {
            if (!isMoveSafe(move, botHead)) {
                movesToRemove.add(move);
            }
        }
        safeMoves.removeAll(movesToRemove);
    }

    private static boolean isMoveSafe(int move, int[] head) {
        int x = head[0];
        int y = head[1];
        switch (move) {
            case 87:
                return x>0 && board[x - 1][y] != 3 && board[x - 1][y] != 4;
            case 83:
                return x < board.length && board[x + 1][y] != 3 && board[x + 1][y] != 4;
            case 68:
                return y < board[0].length - 1 && board[x][y + 1] != 3 && board[x][y + 1] != 4;
            case 65:
                return y > 0 && board[x][y - 1] != 3 && board[x][y - 1] != 4;
            default:
                return false;
        }
    }
    private static int[] findClosestCoord(int[][] coords, int[] current) {
        int[] closest = coords[0];
        int minDistance = Integer.MAX_VALUE;
        for (int[] coord : coords) {
            int dist = Math.abs(coord[0] - current[0]) + Math.abs(coord[1] - current[1]);
            if (dist < minDistance) {
                minDistance = dist;
                closest = coord;
            }
        }
        return closest;
    }
    private static int moveTowardsTarget(int[] target) {
        int closest = 100;
        int fin = 87;
        int[] sim = new int[2];
        if (safeMoves.isEmpty()) {
            return 87;
        }
        for (int move: safeMoves){
            if (move == 87) {
                sim[0] = botHead[0] - 1;
                sim[1] = botHead[1];
            } else if (move == 83) {
                sim[0] = botHead[0] + 1;
                sim[1] = botHead[1];
            } else if (move == 68) {
                sim[0] = botHead[0];
                sim[1] = botHead[1] + 1;
            } else if (move == 65) {
                sim[0] = botHead[0];
                sim[1] = botHead[1] - 1;
            }
            int dist = Math.abs(target[0] - sim[0]) + Math.abs(target[1] - sim[1]);
            if (dist < closest){
                closest = dist;
                fin = move;
            }
        }
        return fin;
    }
    public static void main(String[]args){
    }
}


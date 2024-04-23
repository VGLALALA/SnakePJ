package Backend;
import java.util.ArrayList;
import Backend.Observer;
import Backend.SnakeAPI;
import Backend.Board;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeBot {
    private static Random random = new Random();

    private static int[][] board = Board.board;
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
    public static int getRandomMove() {
        int[] target;
        if (BotHealth <= OppHealth) {
            target = findClosestCoord(foodCoords, botHead);
        } else {
            target = humanHead;
        }
        checkAndRemoveUnsafeMoves();
        return moveTowardsTarget(target);
    }

    private static void checkAndRemoveUnsafeMoves() {
        safeMoves.removeIf(move -> !isMoveSafe(move, botHead));
    }

    private static boolean isMoveSafe(int move, int[] head) {
        int x = head[0];
        int y = head[1];
        switch (move) {
            case 87: return x > 0 && board[x - 1][y] != 3 && !isPartOfSnake(x - 1, y);
            case 83: return x < board.length - 1 && board[x + 1][y] != 3 && !isPartOfSnake(x + 1, y);
            case 68: return y < board[0].length - 1 && board[x][y + 1] != 3 && !isPartOfSnake(x, y + 1);
            case 65: return y > 0 && board[x][y - 1] != 3 && !isPartOfSnake(x, y - 1);
            default: return false;
        }
    }

    private static boolean isPartOfSnake(int x, int y) {
        return isBodyPart(humanBody, x, y) || isBodyPart(botBody, x, y);
    }
    private static boolean isBodyPart(int[][] snake, int x, int y) {
        for (int[] part : snake) {
            if (part[0] == x && part[1] == y) {
                return true;
            }
        }
        return false;
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
        if (safeMoves.isEmpty()) {
            throw new IllegalStateException("No safe moves available");
        }
        return safeMoves.get(random.nextInt(safeMoves.size()));
    }
}

package Backend;
import java.util.ArrayList;
import Backend.Observer;
public class SnakeBot {
//
//    private static Random random = new Random();
//    private static ArrayList<Integer> safeMoves = new ArrayList<>();
//    private static OppHealth = Observer.getHumanHealth();
//    private static BotHealth = Observer.getBotHealth();
//
//    static {
//        safeMoves.add(87); //(Up)
//        safeMoves.add(83); //(Down)
//        safeMoves.add(68); //(Right)
//        safeMoves.add(65); //(Left)
//    }
//    public static int[][] findAllOnes(int[][] board) {
//        List<int[]> tempCoords = new ArrayList<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 1) {
//                    tempCoords.add(new int[] {i, j});
//                }
//            }
//        }
//        int[][] oneCoords = new int[tempCoords.size()][2]; // Each coordinate has two integers
//        for (int i = 0; i < tempCoords.size(); i++) {
//            oneCoords[i] = tempCoords.get(i); // Copy each coordinate pair to the array
//        }
//        return oneCoords;
//    }
//    public static int[] findClosestCoord(int[][] allCoords, int[] current) {
//        int[] closestCoord = allCoords[0];
//        int minDistance = Integer.MAX_VALUE;
//
//        for (int[] coord : allCoords) {
//            int distance = Math.abs(coord[0] - current[0]) + Math.abs(coord[1] - current[1]);
//            if (distance < minDistance) {
//                minDistance = distance;
//                closestCoord = coord;
//            }
//        }
//        return closestCoord;
//    }
//    public static void checkAndRemoveMoves(int[][] board, int[][]snake) {
//        int head[] = snake[snake.length-1];
//        int neck = snake[snake.length-2];
//        int nx = neck[0];
//        int ny = neck[1];
//        int x = head[0];
//        int y = head[1];
//
//        if (x <= 0 || board[x - 1][y] == 3 || (x - 1 == nx && y == ny)) {
//            safeMoves.remove(Integer.valueOf(87));
//        }
//        if (x >= board.length - 1 || board[x + 1][y] == 3 || (x + 1 == nx && y == ny)) {
//            safeMoves.remove(Integer.valueOf(83));
//        }
//        if (y >= board[0].length - 1 || board[x][y + 1] == 3 || (x == nx && y + 1 == ny)) {
//            safeMoves.remove(Integer.valueOf(68));
//        }
//        if (y <= 0 || board[x][y - 1] == 3 || (x == nx && y - 1 == ny)) {
//            safeMoves.remove(Integer.valueOf(65));
//        }
//    }
//    public static int getRandomMove() {
//        if (!safeMoves.isEmpty()) {
//            return safeMoves.get(random.nextInt(safeMoves.size()));
//        } else {
//            throw new IllegalStateException("No safe moves");
//        }
//    }
}
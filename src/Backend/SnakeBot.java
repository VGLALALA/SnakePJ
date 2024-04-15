package Backend;
import java.util.que
public class SnakeBot {

        // Directions arrays for moving up, down, left, right
        private static final int[] dRow = {-1, 1, 0, 0};
        private static final int[] dCol = {0, 0, -1, 1};

        public static List<int[]> bfsWithPath(int[][] grid, int startX, int startY, int endX, int endY) {
            int n = grid.length;

            boolean[][] visited = new boolean[n][m];
            Map<int[], int[]> parent = new HashMap<>();
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startX, startY});
            visited[startX][startY] = true;
            parent.put(new int[]{startX, startY}, null);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == endX && y == endY) {
                    return reconstructPath(parent, current);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dRow[i];
                    int ny = y + dCol[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        parent.put(new int[]{nx, ny}, current);
                    }`
                }
            }

            return Collections.emptyList();
        }

        private static List<int[]> reconstructPath(Map<int[], int[]> parent, int[] endState) {
            LinkedList<int[]> path = new LinkedList<>();
            int[] step = endState;
            while (step != null) {
                path.addFirst(step);
                step = parent.get(step);
            }
            return path;
        }

//        public static void main(String[] args) {
//            int[][] grid = {
//                    {0, 0, 0, 0, 0},
//                    {0, 1, 1, 1, 0},
//                    {0, 1, 0, 0, 0},
//                    {0, 0, 0, 1, 1},
//                    {0, 1, 0, 0, 0}
//            };
//
//            int startX = 0, startY = 0;
//            int endX = 4, endY = 4;
//            List<int[]> path = bfsWithPath(grid, startX, startY, endX, endY);
//
//            if (!path.isEmpty()) {
//                System.out.println("Path from start to end:");
//                for (int[] coords : path) {
//                    System.out.printf("(%d, %d) -> ", coords[0], coords[1]);
//                }
//                System.out.println("End");
//            } else {
//                System.out.println("No path found.");
//            }
//        }


    public static void main(String args[]){

    }
}
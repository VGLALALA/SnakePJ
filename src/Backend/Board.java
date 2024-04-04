package Backend;
import java.util.*;
import java.io.*;


public class Board {
    public static HashMap<String,Integer> inputaker() throws IOException{
        HashMap<String,Integer> map = new HashMap<>();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Set Board Size: ");
        int boardsize = Integer.parseInt(br.readLine());
        map.put("boardsize",boardsize);
        return map;
    }
    public static void arrprint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static int[][] board(int size) {
        int[][] board = new int[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static Tuple<Integer,Integer> foodGen(int boardsize){
        Random random = new Random();
        Tuple<Integer,Integer> coord = new Tuple<>(null,null);
        int randomInt1 = random.nextInt(boardsize)-1;
        int randomInt2 = random.nextInt(boardsize)-1;
        coord.setFirst(randomInt1);
        coord.setSecond(randomInt2);
        return coord;
    }
    public static void main(String[]args) throws IOException {
        HashMap<String,Integer> map = inputaker();
        int boardsize = map.get("boardsize");
        int[][] board = board(boardsize);
        arrprint(board);
        System.out.println("you are a monkey");

    }
}

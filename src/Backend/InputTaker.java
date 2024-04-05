import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InputTaker {
    public static HashMap<String,Integer> inputaker() throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Set Board Size: ");
        int boardsize = Integer.parseInt(br.readLine());
        map.put("boardsize",boardsize);
        return map;
    }
}
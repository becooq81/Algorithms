import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        ArrayList<Integer> fruitHeights = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            fruitHeights.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(fruitHeights);

        while (!fruitHeights.isEmpty() && snake >= fruitHeights.get(0)) {
            snake++;
            fruitHeights.remove(0);
        }

        sb.append(snake);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
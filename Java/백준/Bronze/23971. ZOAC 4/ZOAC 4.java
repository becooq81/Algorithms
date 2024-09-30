import java.util.*;
import java.io.*;

public class Main {
    static int H, W, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); // 행 수
        W = Integer.parseInt(st.nextToken()); // 열 수
        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());

        int perCol = H / (N + 1);
        int perRow = W / (M + 1);
        if (H % (N + 1) > 0)
            perCol += 1;
        if (W % (M + 1) > 0)
            perRow++;
        System.out.println(perCol * perRow); 
    }
}
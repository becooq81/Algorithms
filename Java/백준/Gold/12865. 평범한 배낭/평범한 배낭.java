import java.io.*;
import java.util.*;

public class Main {

    static final int WEIGHT_IDX = 0, VALUE_IDX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][WEIGHT_IDX] = Integer.parseInt(st.nextToken());
            items[i][VALUE_IDX] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (items[i][WEIGHT_IDX] <= w) {
                    int prev = dp[i-1][w];
                    int curr = dp[i-1][w - items[i][WEIGHT_IDX]] + items[i][VALUE_IDX];
                    dp[i][w] = Math.max(prev, curr);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        System.out.println(dp[N][K]);
    }

}
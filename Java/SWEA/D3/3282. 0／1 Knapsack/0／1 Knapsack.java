import java.io.*;
import java.util.*;

public class Solution {

    static final int VOLUME_IDX = 0, VALUE_IDX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] items = new int[N+1][2];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                items[i][VOLUME_IDX] = Integer.parseInt(st.nextToken());
                items[i][VALUE_IDX] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[N+1][K+1];

            for (int i = 1; i <= N; i++) {
                for (int v = 1; v <= K; v++) {
                    if (items[i][VOLUME_IDX] <= v) {
                        // 현재 아이템이 현재 부피에 넣을 수 있는 크기다
                        int prev = dp[i-1][v]; // i-1번째 아이템을 동일 부피에 넣었을 때의 가치
                        // 현재 아이템을 넣기 위해 (현재 무게에서 현재 아이템의 부피만큼 뺀 부피의 최대 가치) 값에 현재 아이템의 가치를 더한다 
                        int curr = items[i][VALUE_IDX] + dp[i-1][v - items[i][VOLUME_IDX]]; 
                        dp[i][v] = Math.max(prev, curr);
                    } else {
                        // 현재 아이템이 현재 부피에 넣을 수 없는 크기다
                        dp[i][v] = dp[i-1][v];
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
        }
        System.out.append(sb);
    }

}
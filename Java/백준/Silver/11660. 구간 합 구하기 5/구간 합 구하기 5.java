import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j =1;
            while(st.hasMoreTokens()) {
                grid[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + grid[i][j] - dp[i-1][j-1];
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int startY = Integer.parseInt(st.nextToken());
                int startX = Integer.parseInt(st.nextToken());
                int endY = Integer.parseInt(st.nextToken());
                int endX= Integer.parseInt(st.nextToken());

                sb.append(dp[endY][endX] - dp[startY-1][endX] - dp[endY][startX-1] + dp[startY-1][startX-1]);
                sb.append("\n");
            }
        }

        

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }


}
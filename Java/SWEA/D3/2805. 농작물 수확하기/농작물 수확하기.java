import java.util.*;
import java.io.*;

public class Solution {
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {            
            int ans = 0;
            int N = Integer.parseInt(br.readLine());
            grid = new int[N][N];

            for(int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < input.length(); j++) {
                    grid[i][j] = input.charAt(j) - '0';
                }
            }

            int red = N/2;
            
            for (int i = 0; i <= N/2; i++) {
                for (int j = red; j < N - red; j++) {
                    ans += grid[i][j];
                    if (N-1-i != i) ans += grid[N-1-i][j];
                }
                red--;
            }

            
            sb.append("#").append(t+1).append(" ").append(ans);
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

}
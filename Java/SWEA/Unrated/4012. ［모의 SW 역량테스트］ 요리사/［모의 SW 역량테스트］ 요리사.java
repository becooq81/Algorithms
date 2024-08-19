import java.util.*;
import java.io.*;

public class Solution {
    static int minResult = Integer.MAX_VALUE;
    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            minResult = Integer.MAX_VALUE;
            
            int N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            for(int i = 0; i < N; i++) {
                int idx = 0;
                st  =  new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    grid[i][idx++] = Integer.parseInt(st.nextToken());
                }
            }

            generateCombinations(0, 0, new int[N/2]);
            sb.append("#").append(t+1).append(" ").append(minResult);
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void generateCombinations(int idx, int start, int[] result) {
        if (idx == result.length) {
            updateMinResult(result);
            return;
        }
        for (int i = start; i < grid.length; i++) {
            result[idx] = i;
            generateCombinations(idx+1, i+1, result);
        }
    }

    private static void updateMinResult(int[] result) {
        int s1 =0, s2 = 0;
        boolean[] selected = new boolean[result.length*2];
        int[] res2 = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            int x = result[i];
            selected[x] = true;
            for (int j = i+1; j < result.length; j++) {
                int y = result[j];
                s1 += grid[x][y] + grid[y][x];
            }
        }
        int idx = 0;
        for (int i = 0; i < result.length*2; i++) {
            if (!selected[i]) res2[idx++] = i;
        }
        for (int i = 0; i < result.length; i++) {
            int x = res2[i];
            for (int j = i+1; j < result.length; j++) {
                int y = res2[j];
                s2 += grid[x][y] + grid[y][x];
            }
        }
        minResult = Math.min(minResult, Math.abs(s1-s2));
    }

}
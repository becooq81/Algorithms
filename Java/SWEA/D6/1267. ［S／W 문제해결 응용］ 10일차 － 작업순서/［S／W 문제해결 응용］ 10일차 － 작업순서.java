import java.util.*;
import java.io.*;

public class Solution {

    static int grid[][], V, E;
    static boolean[] visited;
    static StringBuilder sb =new StringBuilder();

    static void dfs(int curr) {
        visited[curr] = true;
        sb.append(curr).append(" ");
        for (int i = 1; i <= V; i++) {
            if (grid[curr][i] == 1) {
                grid[i][0]--;
                if (!visited[i] && grid[i][0] == 0) {
                    dfs(i);
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (grid[i][0] == 0 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            grid = new int[V+1][V+1];
            while (st.hasMoreTokens()) {
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                grid[n1][n2] = 1;
                grid[n2][0] ++;
            }

            int start = -1;

            for (int i = 1; i <= V; i++) {
                if (grid[i][0] == 0) {
                    start = i;
                }
            }
            sb.append("#").append(t+1).append(" ");
            visited = new boolean[V+1];
            dfs(start);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
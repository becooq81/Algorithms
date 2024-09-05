import java.util.*;
import java.io.*;

public class Solution {

    static int N, M, grid[][];
    static final int INF = Integer.MAX_VALUE;

    static void update() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][k] != INF && grid[k][j] != INF) {
                        // 나보다 큰 애보다 크면 나보다 크지
                        if (grid[i][k] == 1 && grid[k][j] == 1) {
                            grid[i][j] = 1;
                        } 
                        // 나보다 작은 애보다 작으면 나보다 작지
                        else if (grid[i][k] == -1 && grid[k][j] == -1) {
                            grid[i][j] = -1;
                        }
                    }
                }
            }
        }

    }

    static int getAns() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            boolean knowsOrder = true;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (grid[i][j] == INF) {
                    knowsOrder = false;
                    break;
                }
            }
            if (knowsOrder) ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(grid[i], INF);
                grid[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int smaller = Integer.parseInt(st.nextToken()) - 1;
                int greater = Integer.parseInt(st.nextToken()) - 1;
                grid[smaller][greater] = 1;
                grid[greater][smaller] = -1;
            }
            update();

            output.append("#").append(t).append(" ").append(getAns()).append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
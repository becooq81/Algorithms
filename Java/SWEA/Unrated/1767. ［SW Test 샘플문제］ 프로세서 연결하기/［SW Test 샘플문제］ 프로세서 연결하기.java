import java.io.*;
import java.util.*;

public class Solution {
    static int N, grid[][], maxCores, minDist;
    static List<int[]> cores;
    static final int[] DY = {-1, 1, 0, 0}; 
    static final int[] DX = {0, 0, -1, 1}; 

    static void solve(int index, int connectedCores, int distance) {
        if (index == cores.size()) {
            if (connectedCores > maxCores) {
                maxCores = connectedCores;
                minDist = distance;
            } else if (connectedCores == maxCores) {
                minDist = Math.min(minDist, distance);
            }
            return;
        }

        int[] core = cores.get(index);
        int y = core[0], x = core[1];

        if (isConnected(y, x)) {
            solve(index + 1, connectedCores + 1, distance);
            return;
        }

        boolean connectionMade = false;
        for (int d = 0; d < 4; d++) {
            int ny = y, nx = x;
            int length = 0;
            List<int[]> path = new ArrayList<>();

            while (true) {
                ny += DY[d];
                nx += DX[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    connectionMade = true;
                    break;
                }
                if (grid[ny][nx] != 0) {
                    path.clear();
                    break;
                }
                path.add(new int[]{ny, nx});
                length++;
            }

            if (connectionMade && !path.isEmpty()) {
                for (int[] p : path) {
                    grid[p[0]][p[1]] = 2; 
                }
                solve(index + 1, connectedCores + 1, distance + length);

                for (int[] p : path) {
                    grid[p[0]][p[1]] = 0; 
                }
            }
        }
        solve(index + 1, connectedCores, distance);
    }

    static boolean isConnected(int y, int x) {
        // Checks if a core is already on the grid's edge
        return y == 0 || x == 0 || y == N - 1 || x == N - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases
        for (int t = 1; t <= T; t++) {
            cores = new ArrayList<>();
            maxCores = Integer.MIN_VALUE;
            minDist = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine().trim()); // Grid size
            grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (grid[i][j] == 1) {
                        cores.add(new int[]{i, j}); 
                    }
                }
            }

            solve(0, 0, 0); 
            sb.append("#").append(t).append(" ").append(minDist).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
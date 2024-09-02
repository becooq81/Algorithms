import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;
    static int N, M;
    static char[][] grid;

    static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1};

    static int bfsFromW() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][M];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'W') {
                    queue.add(new int[] {i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];

            for (int d = 0; d < 4; d++) {
                int ny = DY[d] + y;
                int nx = DX[d] + x;

                if (isValidCoordinate(ny, nx) && distance[ny][nx] == Integer.MAX_VALUE) {
                    distance[ny][nx] = distance[y][x] + 1;
                    queue.add(new int[] {ny, nx});
                }
            }
        }

        int totalDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'L') {
                    if (distance[i][j] == Integer.MAX_VALUE) return -1;
                    totalDistance += distance[i][j];
                }
            }
        }
        return totalDistance;
    }

    static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }

            int result = bfsFromW();
            output.append("#").append(t).append(" ").append(result);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
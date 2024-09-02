import java.util.*;
import java.io.*;

public class Main {

    static int N, M, grid[][], cheeseCount;
    static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) cheeseCount++;
            }
        }
        int lastCheeseCount = cheeseCount;
        int time = 0;
        while (cheeseCount > 0) {
            lastCheeseCount = cheeseCount;
            bfs();
            time++;
        }
        sb.append(time).append("\n").append(lastCheeseCount);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int[][] visited = new int[N][M];
        visited[0][0] = 1;
        int melted = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y =node[0];
            int x = node[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];
                if (isValidCoordinate(ny, nx) && visited[ny][nx] == 0) {
                    visited[ny][nx] =1;
                    if (grid[ny][nx] == 1) {
                        grid[ny][nx] =0;
                        melted ++;
                    } else {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        cheeseCount -= melted;
        return melted;
    }
}
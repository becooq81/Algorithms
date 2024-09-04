import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int K, W, H, grid[][];
    static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1}, INF = Integer.MAX_VALUE;
    static final int[] HDY = {-2, -1, 1, 2, -2, -1, 1, 2}, HDX = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    static int bfs(int startY, int startX, int endY, int endX) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][][] visited = new int[H][W][K+1];
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];
            int horse = node[2];

            if (y == endY && x == endX) return visited[y][x][horse] -1;

            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];
                if (isVisitable(ny, nx) && visited[ny][nx][horse] == 0) {
                    visited[ny][nx][horse] = visited[y][x][horse] + 1;
                    queue.add(new int[]{ny, nx, horse});
                }
            }

            if (horse < K) {
                for (int d = 0; d < 8; d++) {
                    int ny = y + HDY[d];
                    int nx = x + HDX[d];
                    if (isVisitable(ny, nx) && visited[ny][nx][horse+1] == 0) {
                        visited[ny][nx][horse + 1] = visited[y][x][horse] + 1;
                        queue.add(new int[] {ny, nx, horse + 1});
                    }
                }
            }
        }
        return -1;
    }

    static boolean isVisitable(int y, int x) {
        return isValidCoordinate(y, x) && grid[y][x] == 0;
    }

    static boolean isValidCoordinate(int y, int x) {
        return x >= 0 && y >= 0 && y < H && x < W;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sb.append(bfs(0, 0, H-1, W-1));


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
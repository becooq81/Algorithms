import java.util.*;
import java.io.*;

public class Main {

    static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1};

    static void bfs(int startY, int startX, boolean colorBlind, int N, char[][] grid, boolean[][] visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + DY[i];
                int nx = node[1] + DX[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                    if (grid[startY][startX] == grid[ny][nx] || (colorBlind && ((grid[startY][startX] == 'R' && grid[ny][nx] == 'G') || (grid[startY][startX] == 'G' && grid[ny][nx] == 'R')))) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        boolean[][] colorBlindVisited = new boolean[N][N];

        int segments = 0;
        int colorBlindSegments = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    segments++;
                    bfs(i, j, false, N, grid, visited);
                }
                if (!colorBlindVisited[i][j]) {
                    colorBlindSegments++;
                    bfs(i, j, true, N, grid, colorBlindVisited);
                }
            }
        }

        sb.append(segments).append(" ").append(colorBlindSegments);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
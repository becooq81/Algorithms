import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int m, n, ans;
    static int[][] grid, visited, distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static LinkedList<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        String[] mn = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
                if (grid[i][j] == 1) queue.add(new int[] {i, j});
            }
        }
        visited = new int[n][m];
        distance = new int[n][m];
        
        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && grid[nx][ny] ==0) {
                    visited[nx][ny] = visited[x][y]+ 1;
                    grid[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    System.out.append("-1");
                    return;
                }
                ans = Math.max(ans, visited[i][j]);
            }
        }
        sb.append(ans);
        System.out.append(sb);
    }
}
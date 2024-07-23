import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int m, n, h;
    static LinkedList<int[]> queue = new LinkedList<>();
    static int[][][] visited, grid;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        String[] mnh = br.readLine().split(" ");
        m = Integer.parseInt(mnh[0]);
        n = Integer.parseInt(mnh[1]);
        h = Integer.parseInt(mnh[2]);

        visited = new int[h][n][m];
        grid = new int[h][n][m];

        boolean allRipe = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[k][i][j] = Integer.parseInt(input[j]);
                    if (grid[k][i][j] == 1) queue.add(new int[] {k, i, j});
                    if (grid[k][i][j] == 0) allRipe = false;
                }
            }
        }

        if (allRipe) {
            System.out.append("0");
            return;
        }
        bfs();

        int ans = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[k][i][j] == 0) {
                        System.out.append("-1");
                        return;
                    }
                    ans = Math.max(ans, visited[k][i][j]);
                }
            }
        }
        System.out.append(sb.append(ans));
        
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int z = node[0];
            int y = node[1];
            int x = node[2];
        

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h && visited[nz][ny][nx] == 0 && grid[nz][ny][nx] == 0) {
                    
                    visited[nz][ny][nx] = visited[z][y][x]+1;
                    grid[nz][ny][nx] = 1;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
        }
    }
}
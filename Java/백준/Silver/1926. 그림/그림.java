import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] grid, visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        grid = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }

        // connected components & max items in a component
        int numComp = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currLen = 0;
                if (grid[i][j] == 1) {
                    currLen = bfs(i, j);
                    numComp++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        sb.append(numComp+"\n");
        sb.append(maxLen);
        System.out.append(sb);

    }

    private static int bfs(int startX, int startY) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] start = {startX, startY};
        queue.add(start);
        grid[startX][startY] = 0;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    int[] newNode = {nx, ny};
                    queue.add(newNode);
                    grid[nx][ny] = 0;
                    count ++;
                }
            }
        }
        return count;
    }
}
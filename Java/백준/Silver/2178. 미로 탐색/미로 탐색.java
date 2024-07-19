import java.util.*;
import java.io.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] grid, distance, visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = input.charAt(j)-'0';
            }
        }
        distance = new int[n][m];
        visited = new int[n][m];
        sb.append(bfs(0,0));
        System.out.append(sb);
    }

    private static int bfs(int startX, int startY) {
        int[] start = {startX, startY};
        LinkedList<int[]> queue = new LinkedList<>();
        
        distance[0][0]=1;
        queue.add(start);
        grid[startX][startY] = 0;
        visited[startX][startY] = 1;
        
        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];

            if (x == n-1 && y == m-1) return distance[n-1][m-1]; 

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] ==1 && visited[nx][ny] == 0) {
                    
                    grid[nx][ny] = 0;
                    visited[nx][ny] =1;
                    int[] newNode = {nx, ny};
                    queue.add(newNode);
                    distance[nx][ny] = distance[x][y]+1;
                }
            }
        }

        return 0;
    }
}
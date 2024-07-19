import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, nPair;
    static int[] visited;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        nPair = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new int[n];
        for (int i = 0; i < nPair; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            x--;
            y--;
            grid[x][y] = 1;
            grid[y][x] = 1;
        }

        sb.append(bfs(0));
        System.out.append(sb);

    }

    private static int bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && grid[node][i] == 1) {
                    queue.add(i);
                    visited[i] = 1;
                    count ++;
                }
            }
        }
        return count;
    }
}
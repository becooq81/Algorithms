import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int maxDepth = 0;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                grid[i][j] = input[j];
            }
        }

        visited = new int['Z' - 'A' + 1];
        dfs(0, 0, 1);
        bw.write(String.valueOf(maxDepth));
        bw.flush();
        br.close();
    }

    private static void dfs(int y, int x, int depth) {
        visited[grid[y][x] - 'A'] = depth;

        // System.out.printf("y: %d, x: %d, val: %s, valToInt: %d, depth: %d\n", y, x, grid[y][x], grid[y][x] - 'A', depth);

        maxDepth = Math.max(depth, maxDepth);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if (0==visited[grid[ny][nx] - 'A']) {
                // System.out.printf("   visiting y: %d, x: %d, val: %s, valToInt: %d, depth: %d\n", ny, nx, grid[ny][nx], grid[ny][nx] - 'A', depth);

                dfs(ny, nx, depth+1);
                visited[grid[ny][nx] - 'A'] = 0;
            }
        }
    }
 
}
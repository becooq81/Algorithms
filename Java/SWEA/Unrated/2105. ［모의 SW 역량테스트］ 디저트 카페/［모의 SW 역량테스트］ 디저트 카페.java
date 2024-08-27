import java.io.*;
import java.util.*;

public class Solution {
    static final int[] DY = {1, 1, -1, -1}, DX = {1, -1, -1, 1};
    static int[][] grid;
    static int ans, N;
    static boolean[] visited;
    static int[] count;

    static void dfs(int y, int x, int dir, int startY, int startX) {
        if (dir == 3 && y == startY && x == startX) {
            ans = Math.max(ans, sum(count));
            return;
        }

        for (int i = 0; i < 2; i++) {
            int currDir = nextDir(dir, i);
            int ny = DY[currDir] + y;
            int nx = DX[currDir] + x;

            if (validateCoordinate(ny, nx) && !visited[grid[ny][nx]]) {
                if (currDir == 1 && count[currDir] >= startX) continue;
                if (currDir == 2 && count[currDir] >= count[0]) continue;

                visited[grid[ny][nx]] = true;
                count[currDir]++;
                dfs(ny, nx, currDir, startY, startX);
                visited[grid[ny][nx]] = false;
                count[currDir]--;
            }
        }
    }

    static int sum(int[] count) {
        return count[0] + count[1] + count[2] + count[3];
    }

    static int nextDir(int dir, int move) {
        return (dir + move) % 4;
    }

    static boolean validateCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            ans = -1;
            grid = new int[N][N];
            visited = new boolean[101];
            count = new int[4];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    Arrays.fill(visited, false); 
                    dfs(i, j, 0, i, j);
                }
            }

            sb.append("#").append(t+1).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

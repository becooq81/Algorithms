import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int N, K, grid[][], ans;
    static int[][] visited[];
    static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1};

    static void dfs(int y, int x, int prevHeight, int cut, int depth) {
        visited[y][x][cut] = 1;
        ans = Math.max(depth, ans);

        for (int d = 0; d < 4; d++) {
            int ny = DY[d] + y;
            int nx = DX[d] + x;

            if (isValidCoordinate(ny, nx) && grid[ny][nx] - K < prevHeight && visited[ny][nx][cut] == 0) {
                // 깎음 & 깎아야함
                if (cut == 1 && grid[ny][nx] >= prevHeight) {
                    continue;
                }
                // 깎음 & 깎을 필요 없음
                else if (cut == 1 && grid[ny][nx] < prevHeight) {
                    dfs(ny, nx, grid[ny][nx], 1, depth + 1);
                }
                // 안 깎음 & 깎아야 함
                else if (cut == 0 && grid[ny][nx] >= prevHeight) {
                    dfs(ny, nx, grid[y][x]-1, 1, depth + 1);
                }
                // 안 깎음 & 깎을 필요 없음
                else if (cut == 0 && grid[ny][nx] < prevHeight) {
                    dfs(ny, nx, grid[ny][nx], 0, depth + 1);
                }
            }
        }
        visited[y][x][cut] = 0;

    }

    static boolean isValidCoordinate(int y, int x) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = Integer.MIN_VALUE;
            grid = new int[N][N];
            TreeMap<Integer, List<int[]>> maxHeight = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (!maxHeight.containsKey(grid[i][j])) maxHeight.put(grid[i][j], new ArrayList<>());
                    maxHeight.get(grid[i][j]).add(new int[]{i, j});
                }
            }

            Map.Entry<Integer, List<int[]>> start = maxHeight.pollLastEntry();
            int startHeight = start.getKey();
            List<int[]> startCoordinates = start.getValue();
            visited = new int[N][N][2];
            for (int i = 0; i < startCoordinates.size(); i++) {
                int[] coordinates = startCoordinates.get(i);
                int y = coordinates[0];
                int x = coordinates[1];
                dfs(y, x, grid[y][x], 0, 1);
            }
            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
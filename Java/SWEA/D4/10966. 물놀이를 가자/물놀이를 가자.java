import java.util.*;
import java.io.*;

public class Solution {
    
    static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1};

    static int N, M, ans, visited[][];
    static char[][] grid;
    static StringBuilder output;
    static ArrayDeque<int[]> queue =new ArrayDeque<>();
    
    private static void solve() {
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'W') queue.add(new int[]{i, j});
            }
        }
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += visited[i][j];
            }
        }
    }

    private static void bfs() {
        

        while (!queue.isEmpty()) {

            int[] node = queue.pollFirst();
            
            for (int d = 0; d < 4; d++) {
                int ny = DY[d] + node[0];
                int nx = DX[d] + node[1];

                if (isValidCoordinate(ny, nx) && grid[ny][nx] == 'L' && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[node[0]][node[1]] + 1;
                    queue.add(new int[] {ny, nx});
                }
            }
        }
    }

    private static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    public static void main(String[] args) throws IOException {
        init();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            ans = 0;
            grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            solve();

            output.append("#").append(t).append(" ").append(ans).append("\n");
        }
        br.close();
    
    }
}
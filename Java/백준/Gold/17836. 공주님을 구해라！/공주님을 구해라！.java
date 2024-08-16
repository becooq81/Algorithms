import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        int[] sword = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    sword[0] = i;
                    sword[1] = j;
                }
                grid[i][j++] = val;
            }
        }
        int[] start = {0, 0}, princess = {N-1, M-1};


        int ans = Math.min(bfs(start, princess), aggressiveBfs(sword, princess) + bfs(start, sword));

        bw.write(ans > T  ? "Fail" : String.valueOf(ans));
        bw.flush();
        br.close();
    }

    private static int bfs(int[] start, int[] end) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][M];
        distance[start[0]][start[1]] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];
            // System.out.println("Node: "+Arrays.toString(node)+", distance: " + distance[y][x]);

            if (y == end[0] && x == end[1]) return distance[y][x] - 1;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (distance[ny][nx] == 0 && grid[ny][nx] != 1) {
                    distance[ny][nx] = distance[y][x]+1;
                    queue.addLast(new int[] {ny, nx});
                    // System.out.println("     Exploring: "+ny+","+nx+", disatnce: " + distance[ny][nx]);
                }
            }
        }
        return 100001;
    }

    private static int aggressiveBfs(int[] start, int[] end) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][M];
        distance[start[0]][start[1]] = 1;

        queue.add(start);


        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];

            if (y == end[0] && x == end[1]) return distance[y][x] - 1;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (distance[ny][nx] == 0) {
                    distance[ny][nx] = distance[y][x]+1;
                    queue.addLast(new int[] {ny, nx});
                }
            }
        }
        return 100001;
    }
}
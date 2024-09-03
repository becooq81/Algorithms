import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N, grid[][];
    static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1}, INF = Integer.MAX_VALUE;

    static int getMinDistance(int startY, int startX, int endY, int endX) {
        boolean[][] visited = new boolean[N][N];
        int[][] minCost = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minCost[i], INF);
        }
        minCost[startY][startX] = grid[startY][startX];

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] {startY, startX, minCost[startY][startX]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int y = node[0];
            int x = node[1];
            int cost = node[2];
            if (visited[y][x]) continue;
            visited[y][x] = true;

            if (y == endY && x == endX) return cost;
        
            for (int d = 0; d < 4; d++) {
                int ny = DY[d] + y;
                int nx = DX[d] + x;
                if (isValidCoordinate(ny, nx) && !visited[ny][nx] && minCost[ny][nx] > cost) {
                    minCost[ny][nx] = cost + grid[ny][nx];
                    pq.offer(new int[]{ny, nx, minCost[ny][nx]});
                }
            }
        }

        
        return -1;
    }

    static boolean isValidCoordinate(int y, int x) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        int t= 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j =0; j  < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = getMinDistance(0, 0, N-1, N-1);
            sb.append("Problem ").append(t++).append(": ").append(ans).append("\n");
        }

        // sb.append();

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
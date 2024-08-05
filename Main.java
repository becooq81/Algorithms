import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2206

public class Main {

    private static int N, M;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = input.charAt(j) - '0';
            }
        }
        sb.append(bfs());
        System.out.append(sb);
    }

    private static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][][] visited = new int[N][M][2];

        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        queue.add(new int[] { 0, 0 });
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.pop();
            int y = node[0];
            int x = node[1];
            int sourceVal = grid[y][x];

            System.out.printf("y: %d, x: %d, val: %d\n", y, x, sourceVal);
            if (y == N - 1 && x == M - 1)
                return visited[y][x][0];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && visited[ny][nx][0] + visited[ny][nx][1] == 0) {
                    int currentVal = grid[ny][nx];
                    System.out.printf("     ny: %d, nx: %d, val: %d\n", ny, nx, currentVal);

                    if (sourceVal == 0 && visited[y][x][0] > 0) {
                        if (currentVal == 0) {
                            visited[ny][nx][0] = visited[y][x][0] + 1;
                            System.out.printf("         과거 벽 X, 현재 벽 X, 거리: %d\n", visited[ny][nx][0]);
                        } else {
                            visited[ny][nx][1] = visited[y][x][0] + 1;
                            System.out.printf("         과거 벽 X, 현재 벽 O, 거리: %d\n", visited[ny][nx][1]);
                        }
                        queue.add(new int[] { ny, nx });
                        if (y == N - 1 && x == M - 1) {
                            System.out.println("간드아 #1");
                            return visited[y][x][0];
                        }
                    } else {
                        if (currentVal == 0 && visited[y][x][1] > 0) {
                            visited[ny][nx][1] = visited[y][x][1] + 1;
                            System.out.printf("         과거 벽 O, 현재 벽 X, 거리: %d\n", visited[ny][nx][1]);

                            queue.add(new int[] { ny, nx });
                            if (y == N - 1 && x == M - 1) {
                                System.out.println("간드아 #2");
                                return visited[y][x][0];
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2206

public class Main {

    private static int N, M;
    private static int[][] grid;

    static class Node {
        int y, x, dist;
        boolean brokeWall;

        Node(int y, int x, int dist, boolean brokeWall) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.brokeWall = brokeWall;
        }
    }

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
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        int[][][] visited = new int[N][M][2];

        queue.add(new Node(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // System.out.printf("current: y: %d, x: %d, dist: %d, brokeWall: %s\n", current.y, current.x, current.dist, current.brokeWall);
            if (current.x == M - 1 && current.y == N - 1)
                return current.dist;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + current.y;
                int nx = dx[i] + current.x;

                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;

                if (current.brokeWall && grid[ny][nx] == 0 && visited[ny][nx][1] == 0) {
                    queue.add(new Node(ny, nx, current.dist + 1, true));
                    visited[ny][nx][1] = 1;
                    // System.out.printf("    ny: %d, nx: %d, dist: %d, brokeWall: %s\n", ny, nx, current.dist + 1, true);
                } else if (!current.brokeWall && grid[ny][nx] == 0 && visited[ny][nx][0] == 0) {
                    queue.add(new Node(ny, nx, current.dist + 1, false));
                    visited[ny][nx][0] = 1;
                    // System.out.printf("    ny: %d, nx: %d, dist: %d, brokeWall: %s\n", ny, nx, current.dist + 1, false);
                } else if (!current.brokeWall && grid[ny][nx] == 1 && visited[ny][nx][1] == 0) {
                    queue.add(new Node(ny, nx, current.dist + 1, true));
                    visited[ny][nx][1] = 1;
                    // System.out.printf("    ny: %d, nx: %d, dist: %d, brokeWall: %s\n", ny, nx, current.dist + 1, true);
                }
            }
        }

        return -1;
    }
}
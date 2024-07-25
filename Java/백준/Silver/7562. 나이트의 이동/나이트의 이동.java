import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    private static int T, side;
    private static int[] start, goal;

    private static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        start = new int[2];
        goal = new int[2];
        for (int i = 0; i < T; i++) {
            side = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            
            start[0] = Integer.parseInt(input[0]);
            start[1] = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            goal[0] = Integer.parseInt(input[0]);
            goal[1] = Integer.parseInt(input[1]);

            visited = new int[side][side];
            int ans = bfs(start[0], start[1]);
            sb.append(ans).append("\n");
        }
        System.out.append(sb);
    }

    private static int bfs(int startX, int startY) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];

            if (y == goal[1] && x == goal[0]) return visited[y][x]-1;

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < side && ny < side && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[] {nx, ny});

                    
                }
            }
        }


        return -1;
    }
}
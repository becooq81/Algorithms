import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] grid;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[j][i] == 0) {
                    normalViewBfs(i, j);
                    normalCount++;
                }
            }
        }
        visited = new int[N][N];
        int redgreenCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[j][i] == 0) {
                    redGreenViewBfs(i, j);
                    redgreenCount++;
                }
            }
        }
        sb.append(normalCount).append("\n");
        sb.append(redgreenCount);
        System.out.append(sb);
    }

    private static void normalViewBfs(int startX, int startY) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX]=1;
        char color = grid[startY][startX];

        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[1];
            int y = node[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && color == grid[ny][nx] && visited[ny][nx] == 0) {
                    visited[ny][nx] = 1;

                    queue.add(new int[] {ny, nx});
                }
            }   
        }
    }

    private static void redGreenViewBfs(int startX, int startY) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX]=1;
        char color = grid[startY][startX];
        int redgreen = (color == 'G' || color == 'R') ? 1 : 0;


        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[1];
            int y = node[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[ny][nx] == 0) {
                    int currRedgreen = (grid[ny][nx] == 'G' || grid[ny][nx] == 'R') ? 1 : 0;
                    if (currRedgreen == redgreen) {
                        visited[ny][nx] = 1;

                        queue.add(new int[] {ny, nx});
                    }
                }
            }   
        }
    }
}
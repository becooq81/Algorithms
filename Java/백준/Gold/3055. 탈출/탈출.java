import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[][] waterGrid;

    static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1};
    static final char EMPTY = '.', WATER = '*', ROCK = 'X', BEAVER = 'D', HEDGEHOG = 'S';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        waterGrid = new int[R][C];
        ArrayDeque<int[]> waterQueue = new ArrayDeque<>();
        int startY = -1, startX = -1;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
                if (isWater(i, j)) waterQueue.addLast(new int[] {i, j});
                else waterGrid[i][j] = Integer.MAX_VALUE;
                if (isHedgeHog(i, j)) {
                    startY = i;
                    startX = j;
                }
            }
        }

        updateWater(waterQueue);

        int ans = bfs(startY, startX);
        System.out.println(ans == -1 ? "KAKTUS" : ans);
    }

    private static int bfs(int startY, int startX) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[R][C];

        queue.addLast(new int[] {startY, startX});
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];

            if (isBeaver(y, x)) return visited[y][x] - 1;
            

            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];

                if (!isValidCoordinate(ny, nx) || visited[ny][nx] > 0 || isRock(ny, nx) || isWater(ny, nx)) continue;
                if (waterGrid[ny][nx] > visited[y][x] || waterGrid[ny][nx] == Integer.MAX_VALUE) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.addLast(new int[] {ny, nx});
                }


            }
        }
        return -1;
    }

    private static void updateWater(ArrayDeque<int[]> queue) {
        
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];

                if (!isValidCoordinate(ny, nx) || waterGrid[ny][nx] != Integer.MAX_VALUE || isRock(ny, nx) || isBeaver(ny, nx)) continue;

                waterGrid[ny][nx] = waterGrid[y][x] + 1;
                queue.addLast(new int[] {ny, nx});
            }
        }
    }

    private static boolean isRock(int y, int x) {
        return grid[y][x] == ROCK;
    }

    private static boolean isHedgeHog(int y, int x) {
        return grid[y][x] == HEDGEHOG;
    }

    private static boolean isWater(int y, int x) {
        return grid[y][x] == WATER;
    }

    private static boolean isBeaver(int y, int x) {
        return grid[y][x] == BEAVER;
    }

    private static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < R && x < C;
    }

}
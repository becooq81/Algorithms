import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int WIDTH = 100, IS_AVAILABLE = 1, DESTINATION = 2, TESTCASES = 10;
    static final char HASHTAG = '#', WHITESPACE = ' ', NEW_LINE = '\n';

    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        for (int t = 0; t < TESTCASES; t++) {
            int idx = Integer.parseInt(br.readLine());

            int[][] grid = new int[WIDTH][WIDTH];
            queue.clear();
            for (int i = 0; i < WIDTH; i++) {
                st = new StringTokenizer(br.readLine());
                int j = 0;
                while (st.hasMoreTokens()) {
                    int value =  Integer.parseInt(st.nextToken());
                    if (value==2) queue.addLast(new int[]{i, j, 0});
                    grid[i][j++] = value;
                }
            }
            int ans = solve(grid, new boolean[WIDTH][WIDTH]);
            sb.append(HASHTAG).append(idx).append(WHITESPACE).append(ans).append(NEW_LINE);
        }
        System.out.append(sb);
    }

    private static int solve(int[][] grid, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            int y = curr[0];
            int x = curr[1];

            if (y == 0) return curr[1];

            int left = x-1;
            int right = x + 1;

            if (left >= 0 && grid[y][left] == 1 && !visited[y][left] && curr[2] !=2) {
                queue.add(new int[] {y, left, 1});
            } else if (right < WIDTH && grid[y][right] == 1 && !visited[y][right] && curr[2] != 1) {
                queue.add(new int[] {y, right, 2});
            } else if (y - 1 >= 0 && !visited[y-1][x]) {
                queue.add(new int[] {y-1, x, 0});
            }

        }
        return -1;
    }
}
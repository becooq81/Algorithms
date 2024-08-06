import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] grid;
    private static int blueCount, whiteCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                grid[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }
        recurse(0, 0, N);
        sb.append(whiteCount).append("\n").append(blueCount);
        System.out.append(sb);
    }

    private static void recurse(int y, int x, int half) {
        int sum = 0;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                sum += grid[y + i][x + j];
            }
        }
        if (sum == 0) {
            whiteCount++;
            return;
        } else if (sum == (int) Math.pow(half, 2)) {
            blueCount++;
            return;
        }
        half /= 2;
        recurse(y, x, half);
        recurse(y, x + half, half);
        recurse(y + half, x, half);
        recurse(y + half, x + half, half);
    }
}
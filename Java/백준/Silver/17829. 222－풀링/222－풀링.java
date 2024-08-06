import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] grid;
    static int[] dy = { 0, 0, 1, 1 };
    static int[] dx = { 0, 1, 0, 1 };

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

        sb.append(recurse(0, 0, N));
        System.out.append(sb);

    }

    private static int recurse(int y, int x, int half) {
        if (half == 2) {
            int[] values = new int[4];
            for (int i = 0; i < 4; i++) {
                values[i] = grid[y + dy[i]][x + dx[i]];
            }
            return findSecondMax(values);
        }

        int[] values = new int[4];
        half /= 2;
        values[0] = recurse(y, x, half);
        values[1] = recurse(y + half, x, half);
        values[2] = recurse(y, x + half, half);
        values[3] = recurse(y + half, x + half, half);

        return findSecondMax(values);
    }

    private static int findSecondMax(int[] values) {
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (values[i] > maxVal) {
                maxVal = values[i];
                maxIndex = i;
            }
        }
        values[maxIndex] = Integer.MIN_VALUE;
        int secondMax = Math.max(Math.max(values[0], values[1]), Math.max(values[2], values[3]));
        return secondMax;
    }
}
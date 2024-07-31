import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] grid;
    private static List<PriorityQueue<Integer>> ls = new ArrayList<>();

    private static final int[][] dyx = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                grid[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        sb.append(divide(0, 0, N));
        System.out.append(sb);
    }

    private static int divide(int y, int x, int n) {
        if (n == 1)
            return grid[0][0];
        if (n == 2) {
            int[] values = new int[4];
            for (int i = 0; i < dyx.length; i++) {
                int ny = dyx[i][0] + y;
                int nx = dyx[i][1] + x;
                values[i] = grid[ny][nx];
            }
            return findMin2(values);
        }
        int[] values = new int[4];
        int half = n / 2;
        values[0] = divide(y, x, half);
        values[1] = divide(y + half, x + half, half);
        values[2] = divide(y + half, x, half);
        values[3] = divide(y, x + half, half);
        return findMin2(values);
    }

    private static int findMin2(int[] values) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(values[i], 0);
        }

        int minVal = Math.min(Math.min(values[0], values[1]), Math.min(values[2], values[3]));
        map.remove(minVal);
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        int min2 = Math.min(Math.min(keys[0], keys[1]), keys[2]);
        return min2;
    }
}
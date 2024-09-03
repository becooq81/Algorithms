import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int N, M, grid[][], ans;

    static void solve() {
        for (int k = 1; k <= N+2; k++) {
            int cost = calcCost(k);
            for (int i = 0; i < N; i++) {
                for (int j =0 ; j < N; j++) {
                    int[] res = visitAllPointsWithinManhattanDistance(i, j, k);
                    if (res[0] >= cost) {
                        ans = Math.max(ans, res[1]);
                    }
                }
            }
        }
    }

    static int[] visitAllPointsWithinManhattanDistance(int x0, int y0, int distance) {
        int[] res = new int[2];
        int pay = 0;
        int count = 0;
        distance--;
        for (int x = x0 - distance; x <= x0 + distance; x++) {
            int maxYDist = distance - Math.abs(x - x0);
            for (int y = y0 - maxYDist; y <= y0 + maxYDist; y++) {
                if (isValidCoordinate(y, x) && grid[y][x] ==1) {
                    pay += M;
                    count++;
                }
            }
        }
        res[0] = pay;
        res[1] = count;
        return res;
    }

    static int manhattan(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }

    static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    static int calcCost(int K) {
        return (int) Math.pow(K, 2) + (int) Math.pow(K-1, 2);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j= 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve();
            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
import java.util.*;
import java.io.*;

public class Solution {

    static int N, ans, weights[], total;
    static StringBuilder output;

    static void solve() {
        dfs(0, 0, 0, new boolean[N]);
    }

    static void dfs(int depth, int left, int right, boolean[] used) {
        if (depth == N) {
            if (left >= right) ans ++;
            return;
        }

        if (total - left < left) {
            // System.out.print("depth: "+depth);
            int f = 1;
            for (int i = 1; i <= N - depth; i++) {
                f *= i;
            }
            // System.out.println(", 2^N: "+Math.pow(2, N - depth - 1)+", N!: "+f);
            ans += Math.pow(2, N - depth) * f;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(depth + 1, left + weights[i], right, used);
            if (left >= right + weights[i]) dfs(depth + 1, left, right + weights[i], used);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            total = 0;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            weights = new int[N];
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                total += weights[i];
            }

            solve();

            output.append("#").append(t).append(" ").append(ans).append("\n");
        }
        br.close();
    
    }
}
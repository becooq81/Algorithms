import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int N, worms[][];
    static long ans;
    static boolean[] visited;

    static void solve(int depth, int start) {
        if (depth == N/2) {
            long x = 0, y =0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    x += worms[i][0];
                    y += worms[i][1];
                }
                else {
                    x -= worms[i][0];
                    y -= worms[i][1];
                }
            }
            ans = Math.min(x * x + y * y, ans);
        }
        for (int i = start; i < N; i++) {
            visited[start] = true;
            solve(depth + 1, i + 1);
            visited[start] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ans = Long.MAX_VALUE;
            worms = new int[N][2];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                worms[i][0] = Integer.parseInt(st.nextToken());
                worms[i][1] = Integer.parseInt(st.nextToken());
            }

            solve(0, 0);
            
            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
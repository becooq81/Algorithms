import java.util.*;
import java.io.*;

public class Solution {
    
    static int N;
    static long ans, pairs[][];
    static StringBuilder output;
    
    private static void solve(int depth, boolean[] chosen, int start) {
        if (N / 2 == depth) {
            long x = 0, y = 0;
            for (int i = 0; i < N; i++) {
                if (chosen[i]) {
                    x += pairs[i][0];
                    y += pairs[i][1];
                } else {
                    x -= pairs[i][0];
                    y -= pairs[i][1];
                } 

            }

            ans = Math.min(ans, x * x + y * y);
            return;
        }

        for (int i = start; i < N; i++) {
            chosen[i] = true;
            solve(depth + 1, chosen, i + 1);
            chosen[i] = false;
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
            N = Integer.parseInt(br.readLine());
            ans = Long.MAX_VALUE;

            pairs = new long[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                pairs[i][0] = Long.parseLong(st.nextToken());
                pairs[i][1] = Long.parseLong(st.nextToken());
            }
            solve(0, new boolean[N], 0);


            output.append("#").append(t).append(" ").append(ans).append("\n");
        }
        br.close();
    
    }
}
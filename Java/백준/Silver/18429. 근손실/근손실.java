import java.util.*;
import java.io.*;

public class Main {
    static final char NEW_LINE = '\n', WHITESPACE = ' ';

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] visited, kits;
    static int N, K, count;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new int[N];
        kits = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0; 
        while (st.hasMoreTokens()) {
            kits[i++] = Integer.parseInt(st.nextToken());
        }
        
        solve(0, 500);
        sb.append(count);
        System.out.append(sb);
    }

    private static void solve(int idx, int curr) {
        if (idx == N) {
            count ++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && kits[i] + curr - K >= 500) {
                visited[i] = 1;
                solve(idx+1, kits[i] + curr - K);
                visited[i] = 0;
            }
        }
    }
}
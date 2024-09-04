import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int N, weights[], ans;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();

    static void generatePerm(int depth, int right, int left) {
        if (depth == N) {
            if (left >= right) {
                ans ++;
            }
            return;
        }


        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            
            if (right + weights[i] <= left) {
                generatePerm(depth + 1, right + weights[i], left);
            } 
            if (right <= left + weights[i]) {
                generatePerm(depth + 1, right, left + weights[i]);
            }
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            weights = new int[N];
            set.clear();
            ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(weights);
            generatePerm(0, 0, 0);
            sb.append("#").append(t).append(" ").append(ans);
            if (t != T) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

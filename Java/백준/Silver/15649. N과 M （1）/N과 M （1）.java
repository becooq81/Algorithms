import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permutations(0, 0, new int[M], new boolean[N+1]);

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void permutations(int depth, int idx, int[] result, boolean[] visited) {
        if (depth == M) {
            sb.append(arrToString(result)).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = i;
                permutations(depth+1, idx+1, result, visited);
                visited[i] = false;
            }
        }
    }

    private static String arrToString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int a : result) {
            sb.append(a).append(" ");
        }
        return sb.toString();
    }
}
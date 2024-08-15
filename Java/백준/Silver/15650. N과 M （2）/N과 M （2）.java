import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        makeCombinations(N, M, 0, 1, new int[M], new boolean[N+1]);

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void makeCombinations(int N, int M, int depth, int start, int[] result, boolean[] visited) {
        if (depth == M) {
            sb.append(arrToString(result)).append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                makeCombinations(N, M, depth+1, i + 1, result, visited);
                visited[i] = false;
            }
        }
    }

    private static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(" ");
        }
        return sb.toString().trim();
    }
}
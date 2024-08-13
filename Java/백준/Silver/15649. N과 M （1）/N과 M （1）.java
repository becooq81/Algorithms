import java.util.*;
import java.io.*;

public class Main {
    static final char NEW_LINE = '\n', WHITESPACE = ' ';

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];

        makePermutation(0, new int[M]);

        System.out.append(sb);
    }

    private static void makePermutation(int idx, int[] tmp) {
        if (idx == M) {
            sb.append(listToString(tmp)).append(NEW_LINE);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                tmp[idx] = i;
                visited[i] = 1;
                makePermutation(idx + 1, tmp);
                visited[i] = 0;
                tmp[idx] = 0;
            }
        }
    }

    private static String listToString(int[] tmp) {
        StringBuilder sb = new StringBuilder();
        for (int a : tmp) {
            sb.append(a).append(WHITESPACE);
        }
        return sb.toString().trim();
    }
}
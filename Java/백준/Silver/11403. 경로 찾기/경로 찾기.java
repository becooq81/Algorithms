import java.io.*;
import java.util.*;

public class Main {
    static int N, matrix[][], result[][];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int start, int target) {
        for (int next = 0; next < N; next++) {
            if (matrix[target][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start, next);
            }
        }
    }

    
}
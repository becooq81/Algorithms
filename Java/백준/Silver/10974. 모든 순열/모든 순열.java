import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static StringBuilder output = new StringBuilder();
    
    private static void genPerm(int depth, int[] res, boolean[] visited) {
        if (depth == N) {
            for (int a : res) {
                output.append(a).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            res[depth] = i;
            visited[i] = true;
            genPerm(depth + 1, res, visited);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        genPerm(0, new int[N], new boolean[N+1]);
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
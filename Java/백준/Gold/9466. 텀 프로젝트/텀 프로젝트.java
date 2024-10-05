import java.io.*;
import java.util.*;

public class Main {
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            output.append(n - count).append("\n");
        }
        System.out.print(output);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = students[node];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int temp = next; temp != node; temp = students[temp]) {
                count++;
            }
            count++;
        }

        finished[node] = true; 
    }
}

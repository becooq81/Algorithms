import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int t, n;
    static int[][] locs;
    static int[] visited;
    static boolean successful = false;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            successful = false;
            n = Integer.parseInt(br.readLine());
            locs = new int[n+2][2];
            String[] input = br.readLine().split(" ");
            locs[0][0] = Integer.parseInt(input[0]);
            locs[0][1] = Integer.parseInt(input[1]);

            visited = new int[n+2];
            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");
                locs[j+1][0] = Integer.parseInt(input[0]);
                locs[j+1][1] = Integer.parseInt(input[1]);
            }
            input = br.readLine().split(" ");
            locs[n+1][0] = Integer.parseInt(input[0]);
            locs[n+1][1] = Integer.parseInt(input[1]);
            bfs(0);
            String ans = successful ? "happy" : "sad";
            sb.append(ans+"\n");
        }
        System.out.append(sb);
        // 맥주 최대 20병
        // 50미터 마다 1병

    }

    private static void bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            for (int i = 1; i <n+2; i++) {
                int distance = Math.abs(locs[node][0]-locs[i][0]) + Math.abs(locs[node][1]-locs[i][1]);
                if (node != i && visited[i]== 0 && distance <= 20*50) {
                    if (i == n+1) {
                        successful = true;
                        return;
                    }
                    queue.add(i);
                    visited[i] = 1;
                }
                
            }
        }
    }

}
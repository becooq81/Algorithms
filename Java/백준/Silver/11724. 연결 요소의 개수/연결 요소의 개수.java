import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int N;
    static Map<Integer, TreeSet<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new TreeSet<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        visited = new boolean[N+1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();

            for (int i : map.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.addLast(i);
                }
            }
        }
    }
}
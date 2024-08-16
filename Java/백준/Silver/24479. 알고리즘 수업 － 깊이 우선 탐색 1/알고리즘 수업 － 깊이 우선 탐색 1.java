import java.util.*;
import java.io.*;

public class Main {
    static int[] order;
    static int idx = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new TreeSet<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        order = new int[N+1];
        dfs(N, map, R);
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
        
        br.close();
    }

    private static void dfs(int N, Map<Integer, TreeSet<Integer>> map, int node) {
        order[node] = idx++;
        for (int i : map.get(node)) {
            if (order[i] == 0) dfs(N, map, i);
        }
    }
}
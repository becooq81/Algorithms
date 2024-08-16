import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!map.containsKey(x)) map.put(x, new TreeSet<>());
            if (!map.containsKey(y)) map.put(y, new TreeSet<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }

        int[] order = bfs(R, N, 1, map, new int[N+1]);
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
        
        br.close();
    }

    private static int[] bfs(int R, int N, int idx, Map<Integer, TreeSet<Integer>> map, int[] order) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(R);
        order[R] = idx;
        idx++;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            
            for (int i : map.get(node)) {
                if (order[i] == 0) {     
                    order[i] = idx++;               
                    queue.addLast(i);
                }
            }
        }
        return order;
    }
}
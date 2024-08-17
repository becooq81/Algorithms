import java.util.*;
import java.io.*;

public class Main {

    static int order = 1;
    static int[] result;
    static Map<Integer, TreeSet<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new TreeSet<>((a, b) -> -Integer.compare(a, b)));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        result = new int[N+1];
        dfs(R);

        for (int i = 1; i < N+1; i++) {
            sb.append(result[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void dfs(int start) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (result[node] == 0) {
                result[node] = order++;
                for (int adjacent : map.get(node)) {
                    stack.push(adjacent);
                }
            }
        }
    }
    
}
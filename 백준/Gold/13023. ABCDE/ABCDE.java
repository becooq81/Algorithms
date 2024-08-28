import java.util.*;
import java.io.*;

public class Main {
    static int N, M, size[], parents[], ans;
    static boolean[] visited;
    static Map<Integer, ArrayList<Integer>> friendships;

    static void dfs(int depth, int i) {
        if (ans == 1 || friendships.get(i) == null) return;
        if (depth >= 5) {
            ans = 1;
            return;
        }
        for (int friend : friendships.get(i)) {
            if (!visited[friend]) {
                visited[friend] = true;
                dfs(depth + 1, friend);
                visited[friend] = false;       
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friendships = new HashMap<>();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendships.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            friendships.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for (int i = 0; i < N; i++) {
            if (ans == 1) break;
            visited = new boolean[N];
            dfs(0, i);
        }
        
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
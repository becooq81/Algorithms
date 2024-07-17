import java.io.*;
import java.util.*;
public class Main {
    static int N, M, V;
    static List<Integer> bfsRoute = new ArrayList<>();
    static List<Integer> dfsRoute = new ArrayList<>();
    static int[] dfsVisited;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        graph = new int[N][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            x--;
            y--;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfsVisited = new int[N];
        dfs(V-1);
        for (int i = 0; i < dfsRoute.size(); i++) {
            bw.append((dfsRoute.get(i)+1)+" ");
        }
        bw.append("\n");
        bfs(V-1);
        for (int i = 0; i < bfsRoute.size(); i++) {
            bw.append((bfsRoute.get(i)+1)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start) {
        int[] visited = new int[N];
        visited[start] = 1;
        bfsRoute.add(start);
        List<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove(0);
            for (int i = 0; i < N; i++) {
               if (visited[i] == 0 && graph[current][i]==1) {
                visited[i] = 1;
                bfsRoute.add(i);
                queue.add(i);
               } 
            }
        }
    }

    private static void dfs(int start) {
        dfsRoute.add(start);
        dfsVisited[start] = 1;
        for (int i = 0; i < N; i++) {
            if (dfsVisited[i] == 0 && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
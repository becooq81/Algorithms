import java.util.*;
import java.io.*;

public class Solution {

    static int N, start, maxDistance;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    static void bfs() {
        Arrays.fill(visited, -1);  
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            int currentDistance = visited[current];
            maxDistance = Math.max(maxDistance, currentDistance);

            for (int acquaintance : graph[current]) {
                if (visited[acquaintance] == -1) { // If not visited
                    visited[acquaintance] = currentDistance + 1;
                    queue.addLast(acquaintance);
                }
            }
        }
    }

    static int findMax() {
        int max = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == maxDistance) {
                max = Math.max(i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            graph = new ArrayList[100];
            maxDistance = 0;
            visited = new int[100];

            for (int i = 0; i < 100; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken()) - 1;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
            }

            bfs();
            sb.append("#").append(t + 1).append(" ").append(findMax() + 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
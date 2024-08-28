import java.util.*;
import java.io.*;

public class Solution {
    
    static int N, start, visited[], maxDistance;
    static ArrayList<ArrayList<Integer>> graph;
    static Map<Integer, ArrayList<Integer>> distances;

    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            maxDistance = Math.max(maxDistance, visited[current]);
            if (!distances.containsKey(visited[current])) distances.put(visited[current], new ArrayList<>());
            distances.get(visited[current]).add(current);

            for (int acquaintance : graph.get(current)) {
                if (visited[acquaintance] == 0) {
                    visited[acquaintance] = visited[current] + 1;
                    queue.addLast(acquaintance);
                }
            }
        }
    }

    static int findMax() {
        int max = -1;
        for (int i : distances.get(maxDistance)) {
            max = Math.max(i, max);
        }
        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            graph = new ArrayList<>();
            maxDistance = 0;
            visited = new int[100];
            distances = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken()) - 1;

            for (int i = 0; i < 100; i++) {
                graph.add(new ArrayList<>());
            }
            
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                a--;
                b--;
                graph.get(a).add(b);
            }


            bfs();
            sb.append("#").append(t + 1).append(" ").append(findMax()+1);
            if (t != 9) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
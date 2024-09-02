import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int V, E, start;
    static ArrayList<Node>[] graph;

    static class Node {
        int dest, cost;
        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        int[] dist = new int[V + 1];
        boolean[] checked = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.dest;

            if (checked[current]) continue;
            checked[current] = true;

            for (Node next : graph[current]) {
                if (dist[next.dest] > dist[current] + next.cost) {
                    dist[next.dest] = dist[current] + next.cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
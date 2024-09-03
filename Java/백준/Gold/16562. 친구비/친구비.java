import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, k;
    static long[] friendFees;
    static int[] parents, size;

    static void makeSet() {
        parents = new int[N + 1];
        size = new int[N + 1];
        Arrays.fill(parents, -1);
        Arrays.fill(size, 1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]); // Path compression
    }

    static boolean union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA == rootB) return false;
        if (size[rootA] < size[rootB]) {
            size[rootB] += size[rootA];
            parents[rootA] = rootB;
        } else {
            size[rootA] += size[rootB];
            parents[rootB] = rootA;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friendFees = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendFees[i] = Long.parseLong(st.nextToken());
        }

        makeSet();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            union(f1, f2);
        }

        long minCost = 0;
        Map<Integer, Long> componentMinCost = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int root = findSet(i);
            componentMinCost.put(root, Math.min(componentMinCost.getOrDefault(root, Long.MAX_VALUE), friendFees[i]));
        }

        for (long cost : componentMinCost.values()) {
            minCost += cost;
        }

        if (minCost <= k) {
            bw.write(String.valueOf(minCost));
        } else {
            bw.write("Oh no");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
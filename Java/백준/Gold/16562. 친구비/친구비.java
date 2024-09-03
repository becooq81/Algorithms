import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, k, parents[], size[], friendships[][];
    static long[] friendFees;
    static void makeSet() {
        parents = new int[N+1];
        size = new int[N+1];
        Arrays.fill(parents, -1);
        Arrays.fill(size, 1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (size[aRoot] < size[bRoot]) {
            size[bRoot] += size[aRoot];
            parents[aRoot] = bRoot;
        } else {
            size[aRoot] += size[bRoot];
            parents[bRoot] = aRoot;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friendFees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            friendFees[i] = Long.parseLong(st.nextToken());
        }
        friendships = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friendships[i][0] = f1;
            friendships[i][1] = f2;
        }
        makeSet();
        int cnt = 0;
        for (int[] edge : friendships) {
            if (union(edge[0], edge[1])) {
                if (++cnt == N-1) break;
            }
        }
        for (int i = 1; i <= N; i++) {
            findSet(i);
        }
        
        long minCost = 0;
        Map<Integer, List<Integer>> parentsMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (parents[i] < 0) parents[i] = i;
            if (!parentsMap.containsKey(parents[i])) parentsMap.put(parents[i], new ArrayList<>());
            parentsMap.get(parents[i]).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : parentsMap.entrySet()) {
            long tmpCost = Long.MAX_VALUE;
            for (int a : entry.getValue()) {
                tmpCost = Math.min(friendFees[a-1], tmpCost);
            }
            minCost += tmpCost;
        }
        sb.append(minCost <= k ? minCost : "Oh no");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
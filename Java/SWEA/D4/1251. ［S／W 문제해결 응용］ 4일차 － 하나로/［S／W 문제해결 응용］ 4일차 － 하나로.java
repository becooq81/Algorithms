import java.util.*;
import java.io.*;

public class Solution {
    static long parents[], size[];

    static void makeSet(int N) {
        parents = new long[N];
        size = new long[N];
        Arrays.fill(parents, -1);
        Arrays.fill(size, 1);
    }

    static boolean union(long a, long b) {
        long aRoot = findSet(a);
        long bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (size[(int)aRoot] < size[(int)bRoot]) {
            size[(int)bRoot] += size[(int)aRoot];
            parents[(int)aRoot] = bRoot;
        } else {
            size[(int)aRoot] += size[(int)bRoot];
            parents[(int)bRoot] = aRoot;
        }
        return true;
    }

    static long findSet(long a) {
        if (parents[(int)a] < 0) return a;
        return parents[(int)a] = findSet(parents[(int) a]);
    }

    static long euclid(int y1, int x1, int y2, int x2) {
        return (long) Math.pow(Math.abs(y1-y2), 2) + (long) Math.pow(Math.abs(x1-x2), 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] islands = new int[N][2];
            
            st = new StringTokenizer(br.readLine());
            int idx =0;
            while (st.hasMoreTokens()) {
                for (int i = 0; i < N; i++) {
                    islands[idx++][1] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            idx = 0;
            while (st.hasMoreTokens()) {
                for (int i = 0; i < N; i++) {
                    islands[idx++][0] = Integer.parseInt(st.nextToken());
                }
            }
            double E = Double.parseDouble(br.readLine());

            List<long[]> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    edges.add(new long[] {i, j, euclid(islands[i][0], islands[i][1], islands[j][0], islands[j][1])});
                }
            }

            Collections.sort(edges, (a, b) -> Long.compare(a[2], b[2]));
            makeSet(N);
            long ans =0;
            int cnt = 0;
            for (long[] edge : edges) {
                if (union(edge[0], edge[1])) {
                    ans += edge[2];
                    if (++cnt == N-1) break;
                }
            }
            long finalResult = (long) Math.round(ans * E);
            sb.append("#").append(t+1).append(" ").append(finalResult).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
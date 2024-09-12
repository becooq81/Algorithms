import java.util.*;
import java.io.*;

public class Main {
    static int n, m, parents[], size[];

    static void make() {
        parents= new int[n];
        size = new int[n];
        Arrays.fill(parents, -1);
        Arrays.fill(size, 1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (size[bRoot] > size[aRoot]) {
            size[bRoot] += size[aRoot];
            parents[aRoot] = bRoot;
        } else {
            size[aRoot] += size[bRoot];
            parents[bRoot] = aRoot;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        int count = 1;
        make();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[i][0] = v1;
            edges[i][1] = v2;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) break;
            count++;
        }
        
        sb.append(count == m+1 ? 0 : count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
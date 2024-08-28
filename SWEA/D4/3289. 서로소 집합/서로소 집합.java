import java.util.*;
import java.io.*;

public class Solution {

    static int N, M, parents[], rank[];

    static void make() {
        parents = new int[N + 1];
        rank = new int[N + 1]; 
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    static int findSet(int a) {
        if (a != parents[a]) {
            parents[a] = findSet(parents[a]);
        }
        return parents[a];
    }

    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return;

        if (rank[aRoot] < rank[bRoot]) {
            parents[aRoot] = bRoot;
        } else if (rank[aRoot] > rank[bRoot]) {
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] = aRoot;
            rank[aRoot]++;
        }
    }

    static int check(int a, int b) {
        return findSet(a) == findSet(b) ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            StringBuilder ans = new StringBuilder();
            make();
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (cmd == 0) union(a, b);
                else ans.append(check(a, b));
            }

            sb.append("#").append(t + 1).append(" ").append(ans);
            if (t != T - 1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
import java.util.*;
import java.io.*;
 
public class Solution {
     
    static int N, M, parents[], size[];
 
    static void make() {
        parents = new int[N+1];
        size = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
 
    static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }
 
    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return;
        if (size[aRoot] < size[bRoot]) {
            parents[aRoot] = bRoot;
            size[bRoot] += size[aRoot];    
        } else {
            parents[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
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
            make();
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
                union(a, b);
            }
 
            Set<Integer> ans = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                ans.add(findSet(i));
            }
            sb.append("#").append(t + 1).append(" ").append(ans.size());
            if (t != T - 1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
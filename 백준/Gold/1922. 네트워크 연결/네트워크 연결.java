import java.util.*;
import java.io.*;

public class Main {

    static int N, M, connections[][], parents[], size[];
    
    static long MST() {
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        long cnt = 0, cost = 0;
        for (int[] connection : connections) {
            if (union(connection[0], connection[1])) {
                cost += connection[2];
                if (++cnt == N-1) break;
            }
        }
        return cost;
    }

    static void make() {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        
        connections = new int[M][3];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            connections[m][0] = Integer.parseInt(st.nextToken());
            connections[m][1] = Integer.parseInt(st.nextToken());
            connections[m][2] = Integer.parseInt(st.nextToken());
        }
        make();

        sb.append(MST());
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
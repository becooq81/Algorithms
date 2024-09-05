import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int N, worms[][];
    static long ans;
    static Set<Integer> visited = new HashSet<>();


    static void check(int bitmask) {
        int[] notChosen = new int[N/2];
        int[] chosen = new int[N/2];
        int idxChosen = 0, idxNotChosen = 0;
        for (int i =0; i < N; i++) {
            if ((bitmask & (1 << i)) != 0) chosen[idxChosen++] = i;
            else notChosen[idxNotChosen++] = i;
        }

        long x = 0, y = 0;
        for (int i = 0; i < N/2; i++) {
            x += (worms[chosen[i]][0] - worms[notChosen[i]][0]);
            y += worms[chosen[i]][1] - worms[notChosen[i]][1];
        }
        if (ans > y * y + x * x) {
            ans = y * y + x * x;
        }
    }

    static void genComb(int depth, int start, int bitmask) {
        if (depth == N/2) {
            if (visited.contains(bitmask)) return;

            check(bitmask);
            
            return;
        }

        for (int i = start; i < N; i++) {
            //if (selected[depth]) continue;
            bitmask = bitmask | (1 << i);
            genComb(depth+1, i+1, bitmask);
            bitmask = bitmask & ~(1 << i);
        }
    }

    static long getVectorMag(int[] w1, int[] w2) {
        int y1 = w1[0];
        int x1 = w1[1];
        int y2 = w2[0];
        int x2 = w2[1];
        return (long) ((x2 - x1) * (x2 - x1)) + (long) ((y2 - y1) * (y2 - y1));
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ans = Long.MAX_VALUE;
            worms = new int[N][2];
            // visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                worms[i][0] = Integer.parseInt(st.nextToken());
                worms[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                genComb(0, i, 0);
            }
                output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
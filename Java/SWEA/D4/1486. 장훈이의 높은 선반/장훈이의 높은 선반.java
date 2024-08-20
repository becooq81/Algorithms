import java.io.*;
import java.util.*;

public class Solution {
    static int[] heights;
    static TreeSet<Integer> ts = new TreeSet<>();
    static int ans, N, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {            
            ans = 0;
            ts.clear();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            int idx= 0;
            while (st.hasMoreTokens()) {
                heights[idx++] = Integer.parseInt(st.nextToken());
            }
            generatePermutations(0, 0, new ArrayList<>());

            ans = ts.ceiling(B) - B;

            sb.append("#").append(t+1).append(" ").append(ans);
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void generatePermutations(int depth, int start, List<Integer> result) {
        if (result.size()>= 1) {
            int sum = 0;
            for (int a : result) {
                sum += a;
            }
            ts.add(sum);
        }
        for (int i = start; i < heights.length;i++ ) {
            result.add(heights[i]);
            generatePermutations(depth+1, i+1, result);
            result.remove(result.size()-1);
        }
    }

}
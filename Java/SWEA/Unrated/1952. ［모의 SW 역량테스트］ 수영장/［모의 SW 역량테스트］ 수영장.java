import java.io.*;
import java.util.*;

public class Solution {
    static final int ONE_DAY = 0, ONE_MONTH = 1, THREE_MONTHS = 2, ONE_YEAR = 3;
    static int prices[], ans, usage[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            ans = Integer.MAX_VALUE;
            prices = new int[4];
            usage = new int[12];

            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                prices[idx++] = Integer.parseInt(st.nextToken());
            }

            idx = 0; 
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                usage[idx++] = Integer.parseInt(st.nextToken());
            }

            generatePermutations(0, 0, new int[12]);

            sb.append("#").append(t + 1).append(" ").append(ans);
            if (t != T - 1) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static void generatePermutations(int depth, int sum, int[] result) {
        if (depth >= 12) {
            ans = Math.min(ans, sum);
            return;
        }
        if (usage[depth] == 0) {
            generatePermutations(depth+1, sum, result);
        }
        else {
            for (int i = 0; i < prices.length; i++) {
                result[depth] = i;
                if (i == 0) {
                    generatePermutations(depth + 1, sum + usage[depth] * prices[ONE_DAY], result);
                } else {
                    int skip = 1;
                    if (i == THREE_MONTHS) skip += 2;
                    else if (i == ONE_YEAR) skip += 12;
                    generatePermutations(depth + skip, sum + prices[i], result);
                }
            }
        }
    }
}
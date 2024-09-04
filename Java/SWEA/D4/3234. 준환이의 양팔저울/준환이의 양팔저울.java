import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int N, ans, weights[];
    static Map<String, Integer> memo;

    static int dfs(int depth, int leftSum, int rightSum, int visitedMask) {
        if (leftSum < rightSum) return 0; 
        if (depth == N) return 1; 

        String key = depth + "," + leftSum + "," + rightSum + "," + visitedMask;
        if (memo.containsKey(key)) return memo.get(key);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if ((visitedMask & (1 << i)) == 0) { 
                int newMask = visitedMask | (1 << i);
                count += dfs(depth + 1, leftSum + weights[i], rightSum, newMask);
                count += dfs(depth + 1, leftSum, rightSum + weights[i], newMask);
            }
        }

        memo.put(key, count);
        return count;
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

            weights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            memo = new HashMap<>();
            ans = dfs(0, 0, 0, 0);

            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
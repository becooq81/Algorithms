import java.util.*;
import java.io.*;

public class Solution {
    static int minResult = Integer.MAX_VALUE, maxResult = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            minResult = Integer.MAX_VALUE;
            maxResult = Integer.MIN_VALUE;
            
            int N = Integer.parseInt(br.readLine());
            int[] ops = new int[4];
            int[] nums = new int[N];
            int idx = 0;

            st  =  new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                ops[idx++] = Integer.parseInt(st.nextToken());
            }
            idx=0;
            st  =  new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }

            solve(0, N, nums, ops, new int[4], new int[N-1]);
            // System.out.println(maxResult);
            // System.out.println(minResult);
            sb.append("#").append(t+1).append(" ").append(maxResult-minResult);
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void solve(int idx, int depth, int[] nums, int[] ops, int[] visited, int[] result) {
        if (idx == depth-1) {
            updateMinMax(result, nums);
            // System.out.print(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 3 && nums[idx] == 0) continue;
            if (visited[i] < ops[i]) {
                visited[i] ++;
                result[idx] = i;
                solve(idx+1, depth, nums, ops, visited, result);
                visited[i] --;
            }
        }
    }    

    private static void updateMinMax(int[] result, int nums[]) {
        int sum = nums[0];
        for (int i = 0; i < result.length; i++) {
            sum = op(result[i], sum, nums[i+1]);
        }
        minResult = Math.min(sum, minResult);
        maxResult = Math.max(sum, maxResult);
        // System.out.printf("current: %d, min: %d, max: %d\n", sum, minResult, maxResult);
    }

    private static int op(int idx, int a, int b) {
        switch (idx) {
            case 0:
                return a+b;
            case 1:
                return a-b;
            case 2:
                return a*b;
            default:
                return a/b;
        }
    }
}
import java.util.*;
import java.io.*;

public class Solution {

    static int N, K, ans, nums[];
    static StringBuilder output;

    static void solve() {
        while (K > nums.length) {
            K -= 2;
        }
        genComb(0, 0);
    }

    static void genComb(int depth, int start) {
        if (depth == K) {
            ans = Math.max(ans, getResult());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                swap(i, j);
                genComb(depth + 1, i +1);
                swap(i, j);
            }
        }
    }

    static int getResult() {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i] * Math.pow(10, (nums.length - 1 - i));
        }
        return tmp;
    }

    static void swap(int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    public static void main(String[] args) throws IOException {
        init();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            nums = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                nums[i] = input[i] - '0';
            }

            K = Integer.parseInt(st.nextToken());

            solve();

            output.append("#").append(t).append(" ").append(ans).append("\n");
        }
        br.close();
    
    }
}
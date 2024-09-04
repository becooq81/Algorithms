import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;

    static int ans, swaps, numbers[];

    static void solve(int depth, int start) {
        if (depth == swaps) {
            // System.out.println(Arrays.toString(numbers));
            ans = Math.max(ans, getResult());
        }

        for (int i = start; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    swap(i, j);
                    solve(depth + 1, i+1);
                    swap(i, j);
                }
            }
        }
    }

    static int getResult() {
        int s = 0;
        for (int i = 0; i < numbers.length; i++) {
            s += Math.pow(10, numbers.length-1-i) * numbers[i];
        }
        return s;
    }

    static void swap(int from, int to) {
        int tmp = numbers[from];
        numbers[from] = numbers[to];
        numbers[to] = tmp;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            ans = 0;

            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            numbers = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                numbers[i] = input[i] - '0';
            }
            swaps = Integer.parseInt(st.nextToken());
            while (swaps >  numbers.length) {
                swaps -=2;
            }
            solve(0, 0);
            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
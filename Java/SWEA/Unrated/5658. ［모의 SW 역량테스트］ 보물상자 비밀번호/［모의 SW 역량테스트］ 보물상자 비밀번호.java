import java.util.*;
import java.io.*;
public class Solution {
    static int N, K, nums[];
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            nums =new int[N];
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < N; i++) {
                nums[i] = Character.isDigit(input[i]) ? input[i] - '0' : input[i] - 'A' + 10;
            }

            int side = N / 4;
            TreeSet<Long> result = new TreeSet<>((a, b) -> -Long.compare(a, b));

            for (int startIdx = 0; startIdx < side; startIdx++) {
                for (int nthSide = 0; nthSide < 4; nthSide++) {
                    long tmp = 0;
                    for (int i = 0; i < side; i++) {
                        int idx = (startIdx + i + nthSide * side + N) % N;
                        tmp += nums[idx] * Math.pow(16, side - 1 - i);
                    }
                    result.add(tmp);
                }

            }
            int k = 1;
            while (!result.isEmpty() && k <= K) {
                ans = result.pollFirst();
                k++;
            }

            output.append("#").append(t).append(" ").append(ans).append("\n");

        }

        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
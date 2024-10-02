import java.util.*;
import java.io.*;
public class Solution {

    public static int lis(int[] sequence) {
        int n = sequence.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] sequence = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }
            
            int lisLength = lis(sequence);
            
            System.out.println("#" + t + " " + lisLength);
        }
        br.close();
    }
}

import java.io.*;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            System.out.println("0");
            return;
        }

        long[][] dp = new long[10][N + 1];

        for (int i = 1; i <= 9; i++) {
            dp[i][1] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int d = 0; d <= 9; d++) {
                if (d > 0) {
                    dp[d][len] = (dp[d][len] + dp[d - 1][len - 1]) % MOD;
                }
                if (d < 9) {
                    dp[d][len] = (dp[d][len] + dp[d + 1][len - 1]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[i][N]) % MOD;
        }

        System.out.println(ans);
    }
}
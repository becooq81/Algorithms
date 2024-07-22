import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        if (n==1) {
            System.out.append(sb.append(1));
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            if (i % 2==0) dp[i] = (dp[i-1]*2+1)%10007;
            else dp[i] = (dp[i-1]*2-1)%10007;
        }
        System.out.append(sb.append(dp[n]));
        
    }
}
import java.util.*;

public class Solution {
    static int[] mountains;
    static int ans;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {            
            ans = 0;
            int N = sc.nextInt();
            mountains = new int[N];

            int idx = 0;
            for (int i = 0; i < N; i++) {
                mountains[idx++] = sc.nextInt();
            }

            boolean increasing = false;
            boolean interval = false;
            int increasingCount = 0;
            for (int i = 1; i < N; i++) {
                if (mountains[i-1] < mountains[i]) {
                    if (!increasing) increasingCount=0;
                    increasing = true;
                    interval = false;
                    increasingCount++;
                } else {
                    if (increasing) {
                        increasing = false;
                        interval = true;
                        ans+= increasingCount;
                    } else if (interval) {
                        ans+= increasingCount;
                    }
                }
            }

            sb.append("#").append(t+1).append(" ").append(ans);
            if (t != T-1) sb.append("\n");
        }
        System.out.append(sb);
    }

}
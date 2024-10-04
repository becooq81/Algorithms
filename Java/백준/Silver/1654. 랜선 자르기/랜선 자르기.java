import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long lines[] = new long[N];
        long start =1, end = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            end = Math.max(end, lines[i]);
        }
        
        long ans = Long.MIN_VALUE;
        while (start <= end) {
            long mid= start + (end - start)/2;

            if (isSolution(lines, mid, N)) {
                start = mid + 1;
                ans = Math.max(mid, ans);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);

    }

    private static boolean isSolution(long lines[], long target, int K) {
        int ans = 0;
        for (long line : lines) {
            ans += line / target;
        }
        return ans >= K;
    }
}
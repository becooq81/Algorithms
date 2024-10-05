import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        
        long start =1, end = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            end = Math.max(trees[i], end);
        }
        
        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start)/2;
            if (isSolution(trees, mid, M)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }

        System.out.println(ans);
    }

    private static boolean isSolution(long[] trees, long target, long M) {
        long ans = 0;
        for (long tree : trees) {
            ans += Math.max(tree-target,0);
        }
        return ans >= M;
    }

}
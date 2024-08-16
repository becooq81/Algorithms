import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        long[] nums = new long[n];
        while (st.hasMoreTokens()) {
            nums[idx++] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        long minDiff = Long.MAX_VALUE;
        long a = -1;
        long b = -1;
        Arrays.sort(nums);
        while (left < right) {
            long absSum = Math.abs(nums[left] + nums[right]);
            if (absSum < minDiff) {
                minDiff = absSum;
                a = nums[left];
                b =nums[right];
                if (absSum == 0) break;
            }
            if (nums[left] + nums[right] < 0) {
                left++;
            } else if (nums[left] + nums[right] > 0) {
                right--;
            }
            
        }

        sb.append(a).append(" ").append(b);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
 
}
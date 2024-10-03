import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        long[] budgets = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budgets[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(budgets);
        long totalBudget = Long.parseLong(br.readLine());
        long ans = binarySearch(budgets, totalBudget);
        if (totalBudget - sum(budgets, ans) < 0) ans --;
        System.out.println(ans);
        
    }

    private static long binarySearch(long[] budgets, long totalBudget) {
        long start = 0, end = budgets[budgets.length-1];
        long mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            long tmpSpent = sum(budgets, mid);
            if (totalBudget - tmpSpent == 0) {
                return mid;
            } else if (totalBudget - tmpSpent > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static long sum(long[] nums, long highest) {
        long s = 0;
        for (long val : nums) {
            s += Math.min(val, highest);
        }
        return s;
    }

}
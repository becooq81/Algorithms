import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (binarySearch(nums, nums[i], i))
                ans++;
        }
        System.out.println(ans);
    }
    
    private static boolean binarySearch(int[] nums, int target, int idx) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (left == idx) {
                left++;
                continue;
            } else if (right == idx) {
                right--;
                continue;
            }

            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
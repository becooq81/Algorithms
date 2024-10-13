import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        

        genPerm(0, 0, nums, M, new int[M], new boolean[N]);
        System.out.println(output);
    }

    private static void genPerm(int depth, int next, int[] nums, int M, int[] res, boolean[] visited) {
        if (depth == M) {
            for (int x : res) {
                output.append(x).append(" ");
            }
            output.append("\n");

            return;
        }

        for (int i = next; i < nums.length; i++) {
            if (i > next && nums[i - 1] == nums[i]) continue;
            visited[i] = true;
            res[depth] = nums[i];
            genPerm(depth + 1, i, nums, M, res, visited);
            visited[i] = false;
        }
    }


    
}

import java.util.*;
import java.io.*;
public class Main {
    static int N, M, ans, nums[];
    static StringBuilder output = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    
    private static void genPerm(int depth, int[] res, boolean[] visited) {
        if (depth == M) {
            StringBuilder tmp = new StringBuilder();
            for (int a : res) {
                tmp.append(a).append(" ");
            }
            if (set.add(tmp.toString())) output.append(tmp.toString()).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            res[depth] = nums[i];
            genPerm(depth+1, res, visited);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        genPerm(0, new int[M], new boolean[N]);

        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
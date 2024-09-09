import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> route = new ArrayList<>();
    static StringBuilder output = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        nums = new int[n];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums); 
        dfs(0);

        bw.write(output.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int cnt) {
        if (route.size() == m) {
            for (int a : route) {
                output.append(a).append(" ");
            }
            output.append("\n");
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            
            route.add(nums[i]);
            visited[i] = true;
            dfs(cnt + 1);
            route.remove(route.size() - 1);
            visited[i] = false;
        }
    }
}
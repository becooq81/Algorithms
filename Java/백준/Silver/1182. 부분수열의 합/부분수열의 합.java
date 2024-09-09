import java.util.*;
import java.io.*;
public class Main {
    static int N, S, ans, nums[];
    static StringBuilder output = new StringBuilder();
    
    private static void genComb(int depth, int start, int res) {
        if (depth > 0) {
            if (res == S) ans++;
        }

        if (depth == N) return;

        for (int i = start; i < N; i++) {
            genComb(depth+1, i+1, res+ nums[i]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        genComb(0, 0, 0);

        output.append(ans);
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
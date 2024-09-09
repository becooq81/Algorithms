import java.util.*;
import java.io.*;

public class Solution {

    static int N, ans;
    static StringBuilder output;
    static Set<Integer> mainDiagonal = new HashSet<>();
    static Set<Integer> antiDiagonal = new HashSet<>();
    static Set<Integer> cols = new HashSet<>();

    
    static void solve() {
        nQueen(0, new int[N]);
    }

    static void nQueen(int row, int[] visited) {
        if (row == N) {
            ans++;
            return;
        }
    
        for (int col = 0; col < N; col++) {
            if (cols.contains(col) || mainDiagonal.contains(row - col) || antiDiagonal.contains(row + col)) {
                continue;
            }
    
            visited[row] = col;
            cols.add(col);
            mainDiagonal.add(row - col);
            antiDiagonal.add(row + col);
    
            nQueen(row + 1, visited);
    
            cols.remove(col);
            mainDiagonal.remove(row - col);
            antiDiagonal.remove(row + col);
        }
    }
    

    public static void main(String[] args) throws IOException {
        init();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output.toString());
        bw.flush();
        bw.close();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());

            solve();

            output.append("#").append(t).append(" ").append(ans).append("\n");
        }
        br.close();
    
    }
}
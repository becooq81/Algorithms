import java.io.*;
import java.util.*;

public class Main {   

    static int R, C, ans, grid[][];
    static int[] dy = {-1,0, 1};
    static int[] dx = {1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                grid[i][j] = input[j] == '.' ? 0 : 1;
            }
        }
        for (int i = 0; i < R; i++) {
            if (pipes(i, 0)) ans++;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static boolean pipes(int y, int x) {
        if (x == C-1) {
            // System.out.println("MATCHED");
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && nx < C && ny < R && grid[ny][nx] == 0) {
                // System.out.printf("Exploring: y: %d, x: %d\n", ny, nx);
                grid[ny][nx] = 1;
                if (pipes(ny, nx)) return true;
            }
        }
        return false;

    }
    
}
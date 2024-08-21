import java.io.*;
import java.util.*;
 
public class Solution {

    static int N, grid[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String move = st.nextToken();           
            grid = new int[N][N]; 
            for (int i = 0; i < N; i++) {
                int j =0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    grid[i][j++] = Integer.parseInt(st.nextToken());
                }
            }
            rotate(moveIdx(move));
            solve();
            rotateBack(moveIdx(move));
            sb.append("#").append(t+1).append(" ").append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(grid[i][j]);
                    if (j != N-1) sb.append(" ");
                }
                if (i != N-1) sb.append("\n");
            }
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
 
    private static void rotate(int direction) {
        if (direction == 0) return;
        else if (direction == 1) { // right
            rotate90();
            rotate90();
        } else if (direction == 2) { // up
            rotate90();
            rotate90();
            rotate90();
        } else { // down
            rotate90();
        }
 
    }
 
    private static void rotate90() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
         
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int temp = grid[i][start];
                grid[i][start] = grid[i][end];
                grid[i][end] = temp;
                start++;
                end--;
            }
        }
 
         
    }
 
    private static void rotateBack(int direction) {
        if (direction == 0) return;
        else if (direction == 1) { // right
            rotate90();
            rotate90();
        } else if (direction == 2) { // up
            rotate90();
        } else { // down
            rotate90();
            rotate90();
            rotate90();
        }

    }
 
    private static void solve() {
        int[] ans[] = new int[N][N];
        for (int y = 0; y < N; y++) {
            ArrayDeque<Integer> row = new ArrayDeque<>();
            ArrayDeque<Integer> tmpAns = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                if (grid[y][i] == 0) continue;
                row.addLast(grid[y][i]);
            }
            while (row.size() >= 1) {
                int first = row.pollFirst();
                if (row.isEmpty()) {
                    tmpAns.addLast(first);
                } else if (row.peek() == first) {
                    row.pollFirst();
                    tmpAns.addLast(first*2);
                } else {
                    tmpAns.addLast(first);
                }
            }
            if (!row.isEmpty()) {
                tmpAns.addLast(row.poll());
            }
 
            int i =0;
            while (!tmpAns.isEmpty()) {
                ans[y][i++] = tmpAns.pollFirst();
            }
 
        }
        grid= ans;
    }
     
 
    private static int moveIdx(String move) {
        switch (move) {
            case "left":
                return 0;
            case "right":
                return 1;
            case "up":
                return 2;
            default:
                return 3;
        }
    }
 
}
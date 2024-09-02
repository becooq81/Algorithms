import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder output;
    static StringTokenizer st;
    static int N, M, C, grid[][], maxHoney, allocated[][], ans;

    static void findPairs() {
        for (int i = 0; i < allocated.length * allocated[0].length; i++) {
            for (int j =0; j < allocated.length *allocated[0].length; j++) {
                int row1 = i / allocated[0].length;
                int col1 = i % allocated[0].length;
                int row2 = j / allocated[0].length;
                int col2 = j % allocated[0].length;


                if (Math.abs(i - j) >= 5 || row1 != row2) {
                    ans = Math.max(ans, allocated[row1][col1] + allocated[row2][col2]);
                }
            }
        }

    }
    
    static void allocateHoney() {
        allocated = new int[N][N-M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                maxHoney = Integer.MIN_VALUE;
                findMaxHoney(0, i, j+1, j, 0, new ArrayList<>());
                allocated[i][j] = maxHoney;
            }
        }
    }

    static void findMaxHoney(int depth, int startY, int startX, int starting, int tmpRes, List<Integer> choices) {
        if (tmpRes <= C) {
            // System.out.print("HELLO"+tmpRes+": ");
            int tmp = 0;
            for (int c : choices) {
                tmp += Math.pow(c, 2);
                // System.out.print(c+" ");
            }
            // System.out.println();
            maxHoney = Math.max(maxHoney, tmp);
        } else {
            return;
        }
        for (int next = starting; next < startX + M - 1; next++) {
            choices.add(grid[startY][next]);
            findMaxHoney(depth + 1, startY, startX, next+1, tmpRes + grid[startY][next], choices);
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        output = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            maxHoney = Integer.MIN_VALUE;
            ans = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j =0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            allocateHoney();
            findPairs();

            output.append("#").append(t).append(" ").append(ans);
            if (t != T) output.append("\n");
        }
        bw.write(output.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class Solution {
    
    static char grid[][];
    static int N, ans = Integer.MAX_VALUE;
    static boolean visited[][];

    static final int[] DX = {-1, 0, 1, -1, 1, -1, 0, 1};
    static final int[] DY = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final char LAND_MINE = '*', EMPTY = '.';

    static void bfs(int startY, int startX) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();        
        queue.addLast(new int[] {startY, startX});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];        
            if (findNearMines(y, x) == 0 && grid[y][x] == EMPTY) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + DY[i];
                    int nx = x + DX[i];
                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && grid[ny][nx] == EMPTY && !visited[ny][nx]) {
                        queue.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }    
        }
    }

    static int findNearMines(int y, int x) {
        int nearMines = 0;
        for (int i = 0; i < 8; i++) {
            int ny = y + DY[i];
            int nx = x + DX[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < N && grid[ny][nx] == LAND_MINE) {
                nearMines ++;
            }
        }
        return nearMines;
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            grid = new char[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            ans = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == EMPTY && findNearMines(i, j) == 0 && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == EMPTY && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            sb.append("#").append(t+1).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    static int L, R, C;
    static char[][][] grid;
    static int[][][] visited;
    static int[] start, goal;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        
        while (true) {
            String[] lrc = br.readLine().split(" ");

            L = Integer.parseInt(lrc[0]);
            R = Integer.parseInt(lrc[1]);
            C = Integer.parseInt(lrc[2]);
            if (L == 0 && R == 0 && C == 0) {
                System.out.append(sb);
                break;
            }

            grid = new char[L][R][C];
            visited = new int[L][R][C];
            start = new int[3];
            goal = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char letter = input.charAt(k);
                        grid[i][j][k] = letter;
                        if (letter == 'S') {
                            start[0] = k;
                            start[1] = j;
                            start[2] = i;
                        } else if (letter == 'E') {
                            goal[0] = k;
                            goal[1] = j;
                            goal[2] = i;
                        }
                    }
                }
                br.readLine();
            }
            int ans = bfs(start[0], start[1], start[2]);
            sb.append(ans == -1 ? "Trapped!" : String.format("Escaped in %d minute(s).", ans)).append("\n");
        } 

        
    }

    private static int bfs(int startX, int startY, int startZ) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, startZ});
        visited[startZ][startY][startX] = 1;

        while (!queue.isEmpty()) {
            
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];
            int z = node[2];

            //System.out.printf("x: %d, y: %d, z: %d, visited: %d\n", x, y, z, visited[z][y][x]);

            if (x == goal[0] && y ==goal[1] && z == goal[2]) return visited[z][y][x]-1;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                //System.out.printf("     nx: %d, ny: %d, nz: %d\n", nx, ny, nz);
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < C && ny < R && nz < L && visited[nz][ny][nx] == 0 && grid[nz][ny][nx] !='#') {
                    visited[nz][ny][nx] = visited[z][y][x]+1;
                    queue.add(new int[]{nx, ny, nz});
                    //System.out.printf("                 nx: %d, ny: %d, nz: %d, visited: %d, grid: %s\n", nx, ny, nz, visited[nz][ny][nx], grid[nz][ny][nx]);

                }
            }
        }
        return -1;

    }

}
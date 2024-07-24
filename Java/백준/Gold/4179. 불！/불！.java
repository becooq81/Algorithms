import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int r, c;
    static char[][] grid;
    static int[][] visited;
    static int[] start, end; // {y, x}
    static LinkedList<int[]> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static final char START_LETTER = 'J';
    private static final char FIRE_LETTER = 'F';

    public static void main(String[] args) throws Exception {
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        grid = new char[r][c];
        visited = new int[r][c];

        start = new int[3];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j)==START_LETTER) {
                    start[0] = i;
                    start[1] = j;
                } else if (input.charAt(j)==FIRE_LETTER) {
                    queue.add(new int[] {i, j, 1});
                }
                grid[i][j] = input.charAt(j);
                //System.out.print(grid[i][j]);
            }
        }
        queue.add(start);
        int ans = bfs();
        if (ans==-1) {
            System.out.append("IMPOSSIBLE");
        } else {
            System.out.append(sb.append(ans));
        }
    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int y = node[0];
            int x = node[1];
            int isFire = node[2];

            if (isFire == 0 &&(y == 0 || x == 0 || x == c - 1 || y == r-1)) {
                return visited[y][x]+1;
            }

            //System.out.printf("x: %d, y: %d, isFire: %d\n", x, y, isFire);
            
            LinkedList<int[]> f = new LinkedList<>();
            LinkedList<int[]> j = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < c && ny >= 0 && ny < r && visited[ny][nx] == 0 && grid[ny][nx] == '.') {
                    
                    if (isFire == 1) {
                        visited[ny][nx] = Integer.MAX_VALUE;
                        f.add(new int[]{ny, nx, 1});
                    } else {
                        visited[ny][nx] = visited[y][x] + 1;
                        j.add(new int[]{ny, nx, 0});
                    }
                    //System.out.printf("     nx: %d, ny: %d, visited: %d\n", nx, ny, visited[ny][nx]);
                    
                }
            }
            queue.addAll(f);
            queue.addAll(j);
        }
        return -1;
    }
}
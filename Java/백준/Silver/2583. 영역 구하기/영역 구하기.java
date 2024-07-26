import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    static int m, n, k;
    static int[][] grid;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        String[] mnk = br.readLine().split(" ");
        m = Integer.parseInt(mnk[0]);
        n = Integer.parseInt(mnk[1]);
        k = Integer.parseInt(mnk[2]);

        int[][] rectangles = new int[k][4];
        grid = new int[m][n];

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = Integer.parseInt(input[j]);
            }
        }

        
        for (int i = 0; i < k; i++) {
            int leftBottomX = rectangles[i][0];
            int leftBottomY = rectangles[i][1];
            int rightTopX = rectangles[i][2]-1;
            int rightTopY = rectangles[i][3]-1;

            for (int x = leftBottomX; x <= rightTopX; x++) {
                for (int y = leftBottomY; y <= rightTopY; y++) {
                    grid[y][x] = 1;
                }
            }

        }
        int count = 0;

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    int area = bfs(i, j);
                    count++;
                    areas.add(area);
                }
            }
        }
        Collections.sort(areas);
        sb.append(count).append("\n");
        for (int area : areas) {
            sb.append(area).append(" ");
        }
        System.out.append(sb);
    }

    private static int bfs(int startX, int startY) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        grid[startY][startX] = 1;
        int area = 1;
        //System.out.printf("Start x: %d, start y: %d, area: %d\n", startX, startY, area);
        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[ny][nx] == 0) {
                    
                    grid[ny][nx] = 1;
                    queue.add(new int[] {nx, ny});
                    area++;

                    //System.out.printf("     nx: %d, ny: %d, area: %d\n", nx, ny, area);
                }
            }
        }
        return area;
    }
}
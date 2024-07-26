import java.util.*;
import java.io.*;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" "); 
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);


            int[] start = new int[2]; // {x, y}
            LinkedList<int[]> queue = new LinkedList<>();
            LinkedList<int[]> fires = new LinkedList<>();
            int[][] fireVisited = new int[h][w];
            int[][] personVisited = new int[h][w];
            char[][] grid = new char[h][w];

            for (int r = 0; r < h; r++) {
                String line = br.readLine();
                for (int c = 0; c < w; c++) {
                    grid[r][c] = line.charAt(c);
                    if (grid[r][c] == '@') {
                        start[0] = c; 
                        start[1] = r;
                    } else if (grid[r][c] == '*') {
                        fires.add(new int[] {c, r});
                    }

                    
                }
            }
            queue.add(new int[] {start[0], start[1]});
            
            
            int[][] fireSpread = fireBfs(fires, grid, fireVisited, w, h);
            int ans = bfs(queue, grid, fireSpread, fireVisited, personVisited, w, h);
            sb.append(ans == -1 ? "IMPOSSIBLE" : ans).append("\n");
        }
        System.out.append(sb);
    }

    private static int[][] fireBfs(LinkedList<int[]> fires, char[][] grid, int[][] fireVisited, int w, int h) {
        //System.out.println("FIRE BFS");
        int[][] fireDistance = new int[h][w];
        while (!fires.isEmpty()) {
            int[] node = fires.removeFirst();
            int x = node[0];
            int y = node[1];
            fireVisited[y][x] = 1;

            //System.out.printf("x: %d, y: %d\n", x, y);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < w && ny < h && fireVisited[ny][nx] == 0 && grid[ny][nx] != '#' && grid[ny][nx] != '*') {
                    fireDistance[ny][nx] = fireDistance[y][x]+1;
                    fireVisited[ny][nx] = 1;
                    fires.add(new int[]{nx, ny});

                    //System.out.printf("     nx: %d, ny: %d, visited: %d, distance: %d\n", nx, ny, fireVisited[ny][nx], fireDistance[ny][nx]);
                }
            }
        }
        return fireDistance;
    }

    private static int bfs(LinkedList<int[]> queue, char[][] grid, int[][] fireSpread, int[][] fireVisited, int[][] personVisited, int w, int h) {
        int[][] personDistance = new int[h][w];
        //System.out.println("PERSON BFS");
        while (!queue.isEmpty()) {
            int[] node = queue.removeFirst();
            int x = node[0];
            int y = node[1];
            personVisited[y][x] = 1;

            //System.out.printf("x: %d, y: %d\n", x, y);

            if (x == 0 || y == 0 || x == w-1 || y == h-1) return personDistance[y][x]+1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < w && ny < h && personVisited[ny][nx] == 0 && grid[ny][nx] != '#') {
                    if (fireVisited[ny][nx] == 0 || (fireVisited[ny][nx] == 1 && fireSpread[ny][nx] > personDistance[y][x]+1)) {
                        personVisited[ny][nx] = 1;
                        personDistance[ny][nx] = personDistance[y][x] + 1;
                        queue.add(new int[]{nx, ny});
                        //System.out.printf("     nx: %d, ny: %d, visited: %d, distance: %d\n", nx, ny, personVisited[ny][nx], personDistance[ny][nx]);

                    } 
                }
            }
        }
        return -1;
    }


}
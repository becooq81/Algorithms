import java.util.*;
import java.io.*;

public class Main {

    static ArrayDeque<int[][]> deque = new ArrayDeque<>();
    static char[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        ArrayDeque<int[]> teachers = new ArrayDeque<>();

        init(br, N, teachers);

        boolean success = false;

        combination(0, 0, N, 3, new boolean[N][N], new int[3][2]);
        while (!deque.isEmpty()) {
            int[][] node = deque.pollFirst();

            setGrid(node, true);
            
            success = isSafe(N, teachers);
            if (success) break;

            setGrid(node, false);
        }

        sb.append(success ? "YES" : "NO");
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void init(BufferedReader br, int N, ArrayDeque<int[]> teachers) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                char letter = st.nextToken().charAt(0);
                if (letter == 'T') teachers.addLast(new int[] {i, j});
                grid[i][j++] = letter;
            }
        }
    }

    private static void setGrid(int[][] node, boolean reflected) {
        char replacement = reflected ? 'O' : 'X';
        for (int i = 0; i < 3; i++) {
            grid[node[i][0]][node[i][1]] = replacement;
        }
    }

    private static boolean isSafe(int N, ArrayDeque<int[]> teachers) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {   
                if (grid[i][j] == 'T') {
                    for (int dir = 0; dir < 4; dir++) {
                        for (int distance = 0; distance < N; distance++) {
                            int ny = distance*dy[dir] + i;
                            int nx = distance*dx[dir] + j;
                            if (ny < 0 || nx < 0 || nx >= N || ny >= N) break;
                            if (grid[ny][nx] == 'O') break;
                            else if (grid[ny][nx] == 'S') return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    private static void combination(int depth, int start, int n, int k, boolean[][] visited, int[][] result) {
        if (depth == k) {
            deque.addLast(Arrays.stream(result).map(int[]::clone).toArray(int[][]::new));
            return;
        }
        for (int i = start; i < n*n; i++) {
            int x = i % n;
            int y = i / n;
            if (!visited[y][x] && grid[y][x] != 'T' && grid[y][x] != 'S') {
                visited[y][x] = true;
                result[depth][0] = y;
                result[depth][1] = x;
                combination(depth+1, i+1, n, k, visited, result);
                visited[y][x] = false;
            }
        }
    }
}
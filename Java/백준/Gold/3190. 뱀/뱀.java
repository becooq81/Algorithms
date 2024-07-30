import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K, L;
    // private static int[] apples;
    private static int[][] grid, moves;
    
    // private static final char LEFT90 = 'L';
    // private static final char RIGHT90 = 'D';
    private static final int[][] dyx = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static LinkedList<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0])-1;
            int x = Integer.parseInt(input[1])-1;

            grid[y][x] = 2;
            // 0 은 빈 곳
            // 1 은 뱀의 위치 (꼬리부터 머리까지)
            // 2 는 사과
        }

        L = Integer.parseInt(br.readLine());
        moves = new int[L][2];
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            int move = input[1].equals("D") ? 1 : -1;
            moves[i][0] = time;
            moves[i][1] = move;
        }
        sb.append(search());
        System.out.append(sb);
    }

    private static int search() {
        int headY = 0, headX = 0, tailY = 0, tailX = 0;
        grid[headY][headX] = 1;
        int directionIdx = 0;
        int prevTime = 0;
        int ny = headY;
        int nx = headY;

        for (int i = 0; i < L; i++) {
            // System.out.printf("%d th move) headY: %d, headX: %d, tailY: %d, tailX: %d, prevTime: %d, dirIdx: %d\n", i, headY, headX, tailY, tailX, prevTime, directionIdx);
            int timeInterval = moves[i][0] - prevTime;
            for (int j = 1; j <= timeInterval; j++) {
                ny = headY + dyx[directionIdx][0];
                nx = headX + dyx[directionIdx][1];
                
                // System.out.printf("     ny: %d, nx: %d, current time: %d\n", ny, nx, prevTime + j);

                if (ny >= N || nx >= N || nx < 0 || ny < 0 || grid[ny][nx] == 1) return j + prevTime;
                else {
                    
                    headY = ny;
                    headX = nx;
                    snake.add(new int[] {ny, nx});
                    //System.out.println("SNAKE size: "+snake.size() +" grid[ny][nx]: " + grid[ny][nx]);
                    if (grid[ny][nx] == 2) {
                        // System.out.println("        apple");
                    } else if (grid[ny][nx] == 0) {
                        grid[tailY][tailX] = 0;
                        int[] prevTail = snake.removeFirst();
                        tailY = prevTail[0];
                        tailX = prevTail[1];
                        // System.out.printf("        no apple) new tailY: %d, new tailX: %d\n", tailY, tailX);
                    }
                    grid[ny][nx] = 1;
                }
            }


            directionIdx = (4+directionIdx+moves[i][1]) % 4;
            prevTime = moves[i][0];
        }

        // System.out.printf("final prev time: %d, headY: %d, headX: %d, dirIdx: %d\n", prevTime, headY, headX, directionIdx);


        while (true) {
            // System.out.printf("     ny: %d, nx: %d, grid[ny][nx]: %d, prevTime: %d\n", ny, nx, grid[ny][nx], prevTime);
            ny = ny + dyx[directionIdx][0];
            nx = nx + dyx[directionIdx][1];
            prevTime ++;
            if (ny < 0 || nx < 0 || nx >= N || ny >= N || grid[ny][nx] == 1) return prevTime;
        }

        // return prevTime;
    }
}
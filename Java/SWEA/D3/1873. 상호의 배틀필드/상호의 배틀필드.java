import java.io.*;
import java.util.*;

public class Solution {
    static final char STEEL = '#', BRICK = '*', LAND = '.', WATER = '-';
    static final char LOOKING_UP = '^', LOOKING_DOWN = 'v', LOOKING_LEFT = '<', LOOKING_RIGHT = '>';
    static final char SHOOT = 'S';
    static final Map<Character, Integer> directions = new HashMap<>();

    static final int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static int H, W, N;
    static char[] cmds, grid[];
    static Tank tank;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void play() {
        for (int i = 0; i < N; i++) {
            char cmd = cmds[i];
            if (cmd == SHOOT) {
                int dist = 1;
                while (true) {
                    int ny = tank.y + dy[tank.dir] * dist;
                    int nx = tank.x + dx[tank.dir] * dist;
                    if (!withinGrid(ny, nx)) {
                        break;
                    }
                    if (bulletCanPass(ny, nx)) {
                        dist ++;
                    } else if (bulletCrushes(ny, nx)) {
                        grid[ny][nx] = LAND;
                        break;
                    } else if (bulletDisappears(ny, nx)) {
                        break;
                    }
                }
            } else {
                tank.dir = directions.get(cmd);
                int ny = tank.y + dy[tank.dir];
                int nx = tank.x + dx[tank.dir];
                if (tankCanPass(ny, nx)) {
                    grid[tank.y][tank.x] = LAND;
                    tank.y = ny;
                    tank.x = nx;
                    grid[tank.y][tank.x] = LAND;
                }
            }
        }
        if (tank.dir == 0) grid[tank.y][tank.x] = LOOKING_UP;
        else if (tank.dir == 1) grid[tank.y][tank.x] = LOOKING_DOWN;
        else if (tank.dir == 2) grid[tank.y][tank.x] = LOOKING_LEFT;
        else if (tank.dir == 3) grid[tank.y][tank.x] = LOOKING_RIGHT;
    }

    static boolean tankCanPass(int y, int x) {
        return withinGrid(y, x) && grid[y][x] == LAND;
    }

    static boolean bulletCanPass(int y, int x) {
        return withinGrid(y, x) && (grid[y][x] == WATER || grid[y][x] == LAND);
    }

    static boolean bulletCrushes(int y, int x) {
        return withinGrid(y, x) && grid[y][x] == BRICK;
    }

    static boolean bulletDisappears(int y, int x) {
        return withinGrid(y, x) && grid[y][x] == STEEL;
    }

    static boolean withinGrid(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    static class Tank {
        int y, x, dir;
        Tank (int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        directions.put('U', 0);
        directions.put('D', 1);
        directions.put('L', 2);
        directions.put('R', 3);

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            init();
            play();
            print(t);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static void print(int t) {
        sb.append("#").append(t+1).append(" ");
        for (int i = 0; i < H; i++) {
            sb.append(String.valueOf(grid[i])).append("\n");
        }
    }

    
    static void initGrid() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        grid = new char[H][W];

        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                char c = input[j];
                grid[i][j] = c;
                int foundTank = -1;
                if (c == LOOKING_UP) foundTank = 0;
                else if (c == LOOKING_DOWN) foundTank = 1;
                else if (c == LOOKING_LEFT) foundTank = 2;
                else if (c == LOOKING_RIGHT) foundTank = 3;                
                if (foundTank >= 0) tank = new Tank(i, j, foundTank);
            }
        }
    }

    static void initCmd() throws IOException {
        N = Integer.parseInt(br.readLine());
        cmds = br.readLine().toCharArray();
        
    }

    static void init() throws IOException {
        initGrid();
        initCmd();
    }

    
}
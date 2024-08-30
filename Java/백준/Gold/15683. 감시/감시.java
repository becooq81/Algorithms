import java.util.*;
import java.io.*;

public class Main {
    
    static final int[] DY = {-1, 0, 1, 0}, DX = {0, 1, 0, -1};
    static int N, M, ans = Integer.MAX_VALUE, grid[][];
    static boolean[][][][] seen;
    static ArrayList<CCTV> queue = new ArrayList<>();

    static void initialize() {
        seen = new boolean[queue.size()][4][N][M];
        for (int cctvIdx = 0; cctvIdx < queue.size(); cctvIdx++) {
            CCTV cctv = queue.get(cctvIdx);
            for (int i = 0; i < 4; i++) {
                explore(cctv.y, cctv.x, i, seen[cctvIdx][i]);
                if (cctv.type == 2) {
                    explore(cctv.y, cctv.x, (i+2)%4, seen[cctvIdx][i]);
                } else if (cctv.type == 3) {
                    explore(cctv.y, cctv.x, (i+1)%4, seen[cctvIdx][i]);
                } else if (cctv.type == 4) {
                    explore(cctv.y, cctv.x, (i+1)%4, seen[cctvIdx][i]);
                    explore(cctv.y, cctv.x, (i+2)%4, seen[cctvIdx][i]);
                } else if (cctv.type == 5) {
                    explore(cctv.y, cctv.x, (i+1)%4, seen[cctvIdx][i]);
                    explore(cctv.y, cctv.x, (i+2)%4, seen[cctvIdx][i]);
                    explore(cctv.y, cctv.x, (i+3)%4, seen[cctvIdx][i]);
                }
                /*System.out.printf("%d번째 CCTV, type(%d), 기준방향: %d\n", cctvIdx, cctv.type, i);
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        System.out.print(seen[cctvIdx][i][j][k]);
                    }
                    System.out.println();
                }
                System.out.println();*/
            }
        }
    }

    static void generatePermutations(int depth, int cctvCount, int[] res) {
        if (depth == cctvCount) {
            // System.out.println(Arrays.toString(res));
            ans = Math.min(ans, findBlindSpots(res));
            return;
        }
        for (int i = 0; i < 4; i++) {
            res[depth] = i;
            generatePermutations(depth+1, cctvCount, res);
        }
    } 

    static void explore(int y, int x, int dir, boolean[][] layout) {
        while (isObservable(y, x)) {
            layout[y][x] = true;
            y += DY[dir];
            x += DX[dir];
        }
    }

    static int findBlindSpots(int[] res) {
        // System.out.println("FINDING BLIND SPLOTS");
        boolean[][] layout = new boolean[N][M];
        for (int cctvIdx = 0; cctvIdx < res.length; cctvIdx++) {
            int direction = res[cctvIdx];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (seen[cctvIdx][direction][i][j]) {
                        layout[i][j] = seen[cctvIdx][direction][i][j];
                    }
                    // System.out.print(layout[i][j]);
                }
                // System.out.println();
            }
        }
        int blindSpots = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!layout[i][j]) blindSpots++;
            }
        }
        return blindSpots;
    }
    static boolean isObservable(int y, int x) {
        return isValidCoordinate(y, x) && grid[y][x] != 6;
    }

    static boolean isValidCoordinate(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static class CCTV {
        int y, x, type;
        CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        int walls = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int m = 0;
            while (st.hasMoreTokens()) {
                grid[n][m] = Integer.parseInt(st.nextToken());
                if (grid[n][m] > 0 && grid[n][m] < 6) queue.add(new CCTV(n, m, grid[n][m]));
                else if (grid[n][m] == 6) walls++; 
                m++;
            }
        }

        initialize();
        generatePermutations(0, queue.size(), new int[queue.size()]);

        sb.append(ans - walls);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
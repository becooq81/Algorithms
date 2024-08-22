import java.io.*;
import java.util.*;

public class Main {   

    static int N, M, grid[][], ops[];
    static int[] dy = {-1,0, 1};
    static int[] dx = {1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        grid= new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0; 
            while (st.hasMoreTokens()) {
                grid[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        ops = new int[R];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            ops[i++] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 0; idx < R; idx++) {
            operate(ops[idx]);
        }


        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                sb.append(grid[y][x]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static void operate(int idx) {
        switch (idx) {
            case 1:
                flipVertically();
                break;
            case 2: 
                flipHorizontally();
                break;
            case 3: 
                rotate90();
                break;
            case 4:
                rotate270();
                break;
            case 5: 
                rotateIn4Units();
                break;
            default:
                swapDiagonalIn4Units();
        }
    }

    static void swapDiagonalIn4Units() {
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i + grid.length/2, j);
            }
        }
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i + grid.length/2, j + grid[0].length/2);
            }
        }
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i, grid[0].length/2 + j);
            }
        }
    }

    static void rotateIn4Units() {
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i, j + grid[0].length/2);
            }
        }
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i + grid.length/2, j + grid[0].length/2);
            }
        }
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i + grid.length/2, j);
            }
        }
    }

    static void flipVertically() {
        for (int i = 0; i < grid.length/2; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                swap(i, j, grid.length-1-i, j);
            }
        }
    }
    static void flipHorizontally() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length/2; j++) {
                swap(i, j, i, grid[0].length-1-j);
            }
        }
    }
    static void rotate90() {
        int[] ans[] = new int[grid[0].length][grid.length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                ans[j][grid.length-i-1] = grid[i][j];
            }
        }
        grid = ans;
    }
    static void rotate270() {
        int[] ans[] = new int[grid[0].length][grid.length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                ans[j][i] = grid[i][grid[0].length-1-j];
            }
        }
        grid = ans;
    }

    static void swap(int y1, int x1, int y2, int x2) {
        int tmp = grid[y1][x1];
        grid[y1][x1] = grid[y2][x2];
        grid[y2][x2] = tmp;
    }
    
}
import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int negativeOnes, positiveOnes, zeros;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                grid[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        recurse(0, 0, N);
        sb.append(negativeOnes).append("\n").append(zeros).append("\n").append(positiveOnes);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void recurse(int y, int x, int width) {
        int uniformity = checkUniformity(y, x, width);
        // System.out.printf("y: %d, x: %d, width: %d, uniformity: %d\n", y, x, width, uniformity);
        if (-2 != uniformity) {
            switch (uniformity) {
                case (-1):
                    negativeOnes++;
                    break;
                case (0):
                    zeros++;
                    break;
                default:
                    positiveOnes++;
                    break;
            }
            // System.out.printf("SOLVED: y: %d, x: %d, width: %d, val: %d\n", y, x, width, uniformity);
            // System.out.printf("    negativeOnes: %d, zeros: %d, positiveOnes: %d\n", negativeOnes, zeros, positiveOnes);
        } else {
            width /= 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // System.out.printf("y: %d, x: %d, width: %d\n", y+width*i, x + width*j, width);
                    recurse(y + width * i, x + width*j, width);
                }
            }
        }
    }

    private static int checkUniformity(int y, int x, int width) {
        int standard = grid[y][x];
        // System.out.printf("STANDARD: y: %d, x: %d, val: %d\n", y, x, standard);
        boolean success = true;
        for (int i = y; i < y + width; i++) {
            for (int j = x; j < x + width; j++) {
                if (standard != grid[i][j]) {
                    success = false;
                    break;
                }
            }
        }
        return success ? standard : -2; // -2 면 더 잘라야 한다
    }


}
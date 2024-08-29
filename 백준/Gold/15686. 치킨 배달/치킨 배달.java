import java.util.*;
import java.io.*;

public class Main {
    static int ans = Integer.MAX_VALUE, N, M, grid[][];
    static List<int[]> houses = new ArrayList<>(), chickens = new ArrayList<>();

    static void generateCombinations(int depth, int start, int[] result) {
        if (depth == M) {
            ans = Math.min(sumDistances(result), ans);
            return;
        }
        for (int idx = start; idx < chickens.size(); idx++) {
            result[depth] = idx;
            generateCombinations(depth+1, idx+1, result);
        }
    }

    static int sumDistances(int[] result) {
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            int[] house = houses.get(i);
            int tmp = Integer.MAX_VALUE;
            for (int j =0; j < M; j++) {
                int[] chicken = chickens.get(result[j]);
                tmp = Math.min(tmp, manhattan(house[0], house[1], chicken[0], chicken[1]));
            }
            sum += tmp;
        }
        return sum;
    }

    static int manhattan(int y1, int x1, int y2, int x2) {
        return Math.abs(x1 - x2) + Math.abs(y2 - y1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int cell = Integer.parseInt(st.nextToken());
                if (cell == 1) houses.add(new int[] {i, j});
                else if (cell == 2) chickens.add(new int[] {i, j});
                grid[i][j++] = cell;
            }
        }
        generateCombinations(0, 0, new int[M]);
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
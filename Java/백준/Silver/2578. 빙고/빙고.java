import java.util.*;
import java.io.*;

public class Main {

    static int[][] grid = new int[5][5];
    static Map<Integer, int[]> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        for (int i = 0; i < 5; i++) {
            int j = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                grid[i][j] = val;
                map.put(val, new int[] {i, j});
                j++;
            }
        }

        ArrayDeque<Integer> called = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                called.addLast(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;

        while (!called.isEmpty()){
            int[] coordinates = map.get(called.pollFirst());
            //System.out.printf("coordinates: y: %d, x: %d\n", coordinates[0], coordinates[1]);
            count++;
            grid[coordinates[0]][coordinates[1]] = -1;
            if (satisfiesCondition()) {
                break;
            }
        }
        
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static boolean satisfiesCondition() {
        int y = 0, x = 0;
        int successCount = 0;

        boolean success = true;
        for (int dist = 0; dist < 5; dist++) {
            if (grid[y + dist][x + dist] != -1) {
                success = false;
                break;
            }
        }
        if (success) successCount++;

        for (int i = 0; i < 5; i++) {
            success = true;
            for (int j = 0; j < 5; j++) {
                if (grid[i][j] != -1) {
                    success = false;
                    break;
                }
            }
            if (success) successCount++;
        }

        for (int i = 0; i < 5; i++) {
            success = true;
            for (int j = 0; j < 5; j++) {
                if (grid[j][i] != -1) {
                    success = false;
                    break;
                }
            }
            if (success) successCount++;
        }


        success = true;
        for (int dist = 0; dist < 5; dist++) {
            if (grid[dist][4- dist] != -1) {
                success = false;
                break;
            }
        }
        if (success) successCount++;


        return successCount >= 3;
    }
}
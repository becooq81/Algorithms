import java.util.*;
import java.io.*;

public class Main {

    static int WIDTH = 9;
    static int[][] grid = new int[WIDTH][WIDTH];
    static List<Node> emptyNodes = new ArrayList<>();
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < WIDTH; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) emptyNodes.add(new Node(i, j, val));
                grid[i][j++] = val;
            }
        }

        ans = new int[9][9];
        
        generatePermutations(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void generatePermutations(int depth) {
        if (depth == emptyNodes.size()) {
            ans = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
            return;
        }

        Node n = emptyNodes.get(depth);

        for (int i = 1; i <= 9; i++) {
            // System.out.printf("PER: n.y: %d, n.x: %d, i: %d\n",n.y, n.x, i);
            if (check(n.y, n.x, i)) {
                grid[n.y][n.x] = i;
                generatePermutations(depth + 1);
                grid[n.y][n.x] = 0;
            }
        }
    }

    private static boolean check(int y, int x, int num) {
        for (int nx = 0; nx < WIDTH; nx++) {
            if (grid[y][nx] == num) return false;
        }
        
        for (int ny = 0; ny < WIDTH; ny++) {
            if (grid[ny][x] == num) return false;
        }

        int startRow = (y/3) * 3;
        int startCol = (x/3) * 3;
        for (int xDist = 0; xDist < 3; xDist++) {
            for (int yDist = 0; yDist < 3; yDist++) { 
                if (grid[startRow+yDist][startCol+xDist] == num) return false;
            }
        }
        return true;
    }

    static class Node {
        int y, x, data;
        Node (int y, int x, int data) {
            this.y = y;
            this.x = x;
            this.data = data;
        }
    }
    
}
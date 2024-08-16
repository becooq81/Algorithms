import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] grid = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                grid[a][b] = 1;
                grid[b][a] = 1;
            }

            int count = 0;
            for (int size = 0; size <= N; size++) {
                count += countValidCombinations(size, grid);
            }

            sb.append("#").append(t + 1).append(" ").append(count);
            if (t != T - 1) sb.append("\n");
        }
        System.out.append(sb);
    }

    private static int countValidCombinations(int size, int[][] grid) {
        int N = grid.length - 1;
        int count = 0;
        List<Integer> combination = new ArrayList<>();
        count = countValidCombinations(size, 1, N, combination, grid);
        return count;
    }

    private static int countValidCombinations(int size, int start, int N, List<Integer> combination, int[][] grid) {
        if (combination.size() == size) {
            return satisfiesCondition(combination, grid) ? 1 : 0;
        }

        int count = 0;
        for (int i = start; i <= N; i++) {
            combination.add(i);
            count += countValidCombinations(size, i + 1, N, combination, grid);
            combination.remove(combination.size() - 1);
        }
        return count;
    }

    private static boolean satisfiesCondition(List<Integer> combo, int[][] grid) {
        for (int i = 0; i < combo.size(); i++) {
            for (int j = i + 1; j < combo.size(); j++) {
                if (grid[combo.get(i)][combo.get(j)] == 1) return false;
            }
        }
        return true;
    }
}
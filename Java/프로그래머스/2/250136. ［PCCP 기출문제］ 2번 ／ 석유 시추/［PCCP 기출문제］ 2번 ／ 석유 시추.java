import java.util.*;
class Solution {
    private final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1}, INF = Integer.MAX_VALUE, NEG_INF = Integer.MIN_VALUE;
    static int N, M;
    static Map<Integer, Integer> perCol = new HashMap<>();
    
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < M; i++) {            
            for (int j = 0; j < N; j++) {
                if (land[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i, land, visited);
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (!perCol.containsKey(i)) continue;
            answer = Math.max(answer, perCol.get(i));
        }
        
        return answer;
    }
    
    private int bfs(int startY, int startX, int[][] land, boolean[][] visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        visited[startY][startX] = true;
        queue.add(new int[] {startY, startX});
        int count = 1;
        
        int minX = Math.min(INF, startX), maxX = Math.max(NEG_INF, startX);
        
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int y = node[0];
            int x = node[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];
                if (isValidCoordinate(ny, nx) && !visited[ny][nx] && land[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                    count++;
                    minX = Math.min(minX, nx);
                    maxX = Math.max(maxX, nx);
                }
            }
        }
        // System.out.printf("minX: %d, maxX: %d, count: %d\n", minX, maxX, count);
        updateMap(minX, maxX, count);
        return count;
    }
    
    private void updateMap(int minX, int maxX, int count) {
        for (int i = minX; i <= maxX; i++) {
            if (!perCol.containsKey(i)) perCol.put(i, 0);
            perCol.put(i, perCol.get(i) + count);
        }
    }
    
    private boolean isValidCoordinate(int y , int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
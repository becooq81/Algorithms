import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    private int bfs(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ans = 0;
        
        List<int[]> queue = new ArrayList<>();
        int[][] visited = new int[maps.length][maps[0].length];
        int[] tmp = {0, 0};
        queue.add(tmp);
        
        /**
        for (int i = 0; i < queue.size(); i++) {
            System.out.print("("+queue.get(i)[0]+","+queue.get(i)[1]+")");
        }
        System.out.println();
        **/    
        while (queue.size() > 0) {            
            int x = queue.get(0)[0];
            int y = queue.get(0)[1];
            queue.remove(0);

            
            if (x == maps.length-1 && y == maps[0].length-1) return visited[x][y] +1;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    int[] t = {nx, ny};
                    queue.add(t);
                }
            }
            /**
            for (int i = 0; i < queue.size(); i++) {
                System.out.print("("+queue.get(i)[0]+","+queue.get(i)[1]+")");
            }
            System.out.println();
            **/
        }
            
        
        return -1;
    }
}
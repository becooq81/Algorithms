import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] visited = new int[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 0) {
                visited = bfs(i, computers, visited);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private int[] bfs(int visiting, int[][] computers, int[] visited) {
        List<Integer> queue = new ArrayList<>();
        visited[visiting] = 1;
        queue.add(visiting);
        
        while (queue.size() >= 1) {
            
            
            int x = queue.get(0);
            queue.remove(0);
            
            
            for (int i = 0; i < computers[x].length; i++) {
                if (computers[x][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        return visited;
    }
}
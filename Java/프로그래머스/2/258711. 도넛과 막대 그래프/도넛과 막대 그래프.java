import java.util.*;
class Solution {
    Stack<Integer> route = new Stack<>();
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
           
        // 정점 값 저장하는 리스트
        Set<Integer> vertices = new HashSet<>();
        
        // 정점 값의 인덱스에 나가는 간선 수 저장하는 배열
        int[] outgoing = new int[1000001];
        
        // 정점 값의 인덱스에 들어오는 간선 수 저장하는 배열
        int[] incoming = new int[1000001];
        
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            
            vertices.add(start);
            vertices.add(end);
            
            outgoing[start] ++;
            incoming[end] ++;
        }
        
        List<Integer> categorized = new ArrayList<>();
        
        for (int vertex : vertices) {
            if (outgoing[vertex] >= 2 && incoming[vertex] == 0) answer[0] = vertex;
            else if (outgoing[vertex] == 0 && incoming[vertex] >= 1) answer[2] ++;
            else if (outgoing[vertex] >= 2 && incoming[vertex] >= 2) answer[3] ++;
            
        }
        answer[1] = outgoing[answer[0]] - answer[2] - answer[3];
        
        return answer;
    }
}
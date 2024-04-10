import java.util.*;

class Solution {
    List<String> routes; 
    int[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        int visitedAirports = 0;
        routes = new ArrayList<>();
        visited = new int[tickets.length];
        
        dfs("ICN", "ICN", tickets, visitedAirports);
        
        Collections.sort(routes);
        answer = routes.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int visitedAirports){
        if (visitedAirports == tickets.length){
            routes.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && visited[i] == 0){
                visited[i] = 1;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, visitedAirports + 1);
                visited[i] = 0;
            }
        }
    }
    
}
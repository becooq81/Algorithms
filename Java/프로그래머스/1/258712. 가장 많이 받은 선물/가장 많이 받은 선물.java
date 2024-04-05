import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        List<Integer> gifts_count = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            gifts_count.add(0);
        }
        int[][] gifts_graph = new int[friends.length][friends.length];
        
        for (int i = 0; i < gifts.length; i++) {
            String sender = gifts[i].split(" ")[0];
            String receiver = gifts[i].split(" ")[1];
            
            int idx_sender = Arrays.asList(friends).indexOf(sender);
            int idx_receiver = Arrays.asList(friends).indexOf(receiver);
            
            gifts_count.set(idx_sender, gifts_count.get(idx_sender)+1);
            gifts_count.set(idx_receiver, gifts_count.get(idx_receiver)-1);
            
            gifts_graph[idx_sender][idx_receiver] += 1;
            
        }
        
        int[] next = new int[friends.length];
        for (int i = 0;i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (gifts_graph[i][j] > gifts_graph[j][i]) {
                    next[i] += 1;
                } 
                else if (gifts_graph[i][j] < gifts_graph[j][i]) {
                    next[j] += 1;
                }
                else {
                    if (gifts_count.get(i) > gifts_count.get(j)) {
                        next[i] += 1;
                    } else if (gifts_count.get(i) < gifts_count.get(j)) {
                        next[j] += 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < friends.length; i ++) {
            if (next[i] > answer) {
                answer = next[i];
            }
        }
        
        return answer;
    }
}
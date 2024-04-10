import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean found = false;
        List<String> wordList = new ArrayList<>();
        wordList.add(begin);
        for (String word : words) {
            wordList.add(word);
            if (word.equals(target)) {
                found = true;
            }
        }
        if (!found) return 0;
        answer = bfs(begin, target, wordList);
        return answer;
    }
    private int bfs(String begin, String target, List<String> words) {
        int ans = 0;
        List<Integer> queue = new ArrayList<>();
        int[] visited = new int[words.size()];
        visited[0] = 1;
        
        int[] dist = new int[words.size()];
        queue.add(0);
    
        
        while (queue.size() >= 1) {
            int node = queue.get(0);
            queue.remove(0);
            //System.out.println("NODE: "+ node + " =>"+words.get(node));
            if (words.get(node).equals(target)) {
                return dist[node];
            }
            
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).equals(words.get(node)) || visited[j] == 1) continue;
                int sameCount = 0;
                for (int i = 0; i < words.get(j).length(); i++) {
                    if (words.get(j).charAt(i)==words.get(node).charAt(i)) sameCount ++;
                }
                if (sameCount == words.get(j).length()-1) {
                    dist[j] = dist[node] + 1;
                    visited[j] = 1;
                    queue.add(j);
                }
            }
            /**
            System.out.println("QUEUE");
            for (int i = 0; i < queue.size(); i++) {
                System.out.print(queue.get(i)+" ");
            }
            System.out.println();
            System.out.println("DISTANCE");
            for (int i = 0; i < dist.length; i++) {
                System.out.print(dist[i]);
            }
        
            System.out.println();
            **/
        }
        
        
        return 0;
    }
}
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> runners = new HashMap<>();
        for (String p : participant) {
            if (!runners.containsKey(p)) {
                runners.put(p, 0);
            }
            runners.put(p, runners.get(p)+1);
        }
        
        for (String completer : completion) {
            runners.put(completer, runners.get(completer)-1);
        }
        
        for (String key : runners.keySet()) {
            if (runners.get(key) > 0) {
                return key;
            }
        }
        
        return answer;
    }
}
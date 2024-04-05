import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> storage = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i ++) {
            storage.add(ingredient[i]);
        }
        if (storage.size() < 4) {
            return 0;
        }
        
        int idx = 0;
        while (idx +3<= storage.size()-1) {
            if (idx >= 0) {
                if (storage.get(idx) == 1 && storage.get(idx+1) == 2 && storage.get(idx+2) == 3 && storage.get(idx+3) == 1) {
                    storage.remove(idx);
                    storage.remove(idx);
                    storage.remove(idx);
                    storage.remove(idx);
                    answer ++;
                    idx -=5;
                    }
                
            }
            idx ++;
            
        }
        
        return answer;
    }
}
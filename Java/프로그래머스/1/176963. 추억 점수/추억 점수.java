import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map <String, Integer> nameYearning = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameYearning.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i ++) {
            int ans = 0;
            for (int j = 0; j < photo[i].length; j ++) {
                String appeared = photo[i][j];
                if (nameYearning.containsKey(appeared)) {
                    ans += nameYearning.get(photo[i][j]);
                }
                
            }
            answer[i] = ans;
        }
        
        
        return answer;
    }
}
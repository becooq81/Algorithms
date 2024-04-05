import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> legends = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (legends.size() < k) {
                legends.add(score[i]);
            } 
            
            else {
                int min = solveMin(legends);
                if (score[i] >= min) {
                    int idx = legends.indexOf(min);
                    legends.remove(idx);
                    legends.add(score[i]);
                }
            }
            
            
            
            answer[i] = solveMin(legends);
        }
        
        
        return answer;
    }
    
    private int solveMin(List<Integer> l) {
        int min = l.get(0);
        for (Integer element : l) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }
}
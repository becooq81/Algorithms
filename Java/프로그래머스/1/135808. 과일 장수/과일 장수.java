import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        
        int[] tap = new int[k];
        
        for (int j = 0; j < score.length; j++) {
            tap[score[j]-1] += 1;
        }
        
        
        int totalAmount = score.length;
        
        int countingAmount = 0;
        int idx = tap.length-1;
        int inBox = 0;
        while (countingAmount < totalAmount) {
            if (tap[idx] <= 0) {
                idx -=1;
                if (idx == -1) {
                    break;
                }
                continue;
            }
            
            int remove = Math.min(tap[idx], m-inBox);
            inBox += remove;
            tap[idx] -= remove;
            countingAmount += remove;
            if (inBox == m) {
                answer += (idx+1) * m;
                inBox = 0;
            }
        }
        
        
        return answer;
    }
}
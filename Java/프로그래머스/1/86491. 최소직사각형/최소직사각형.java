class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxLen = 0;
        int shorterMaxLen = 0;
        
        for (int j = 0; j < sizes.length; j++) {
            int tmpMax = Math.max(sizes[j][0], sizes[j][1]);
            int tmpMin = Math.min(sizes[j][0], sizes[j][1]);
            
            if (tmpMax > maxLen) maxLen = tmpMax;
            if (tmpMin > shorterMaxLen) shorterMaxLen = tmpMin;
        }
        
    
        
        
        
        return maxLen * shorterMaxLen;
    }
}
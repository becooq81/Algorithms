class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        s = s.substring(1);
        int same = 1;
        int diff = 0;
        
        if (s.length() == 0) {
            return 1;
        }
        
        while (s.length()> 0) {
            char c = s.charAt(0);
            s = s.substring(1);
            if (c == x) {
                same ++;
            } else {
                diff ++;
            }
            if (same == diff) {
                if (s.length() > 0) {
                    x = s.charAt(0);
                }
                answer ++;
            }
            if (s.length() == 0 && same != diff) {
                answer ++;
            }
        }
        
        return answer;
    }
}
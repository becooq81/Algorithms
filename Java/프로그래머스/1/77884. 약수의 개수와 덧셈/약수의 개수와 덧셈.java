class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int cur = getFactors(i);
            if (cur % 2 == 0) answer += i;
            else answer-=i;
        }
        return answer;
    }
    private int getFactors(int num) {
        int ans = 0;
        for (int i = 1; Math.pow(i, 2) <= num; i++) {
            if (num % i == 0) ans += 2;
            if (Math.pow(i, 2) == num) ans-=1;
        }
        return ans;
    }
}
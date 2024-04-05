class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long spent = 0;
        for (long i =0; i < count; i++) {
            spent += (i+1) * price;
        }
        
        if (spent > money) {
            answer = spent - money;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}
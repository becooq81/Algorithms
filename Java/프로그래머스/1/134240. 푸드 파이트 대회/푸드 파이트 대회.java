class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        for (int i = food.length-1; i >=1; i--) {
            int count = food[i];
            if (count % 2 == 1) {
                count -=1;
            }
            String addition = Integer.toString(i).repeat(count/2);
            answer = addition + answer + addition;
        }
        
        return answer;
    }
}
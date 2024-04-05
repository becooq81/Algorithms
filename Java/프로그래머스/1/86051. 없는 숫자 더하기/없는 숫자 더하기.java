class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] found = new boolean[10];
        
        for (int number : numbers) {
            found[number] = true;
        }
        
        for (int i = 0; i < found.length; i++) {
            if (found[i] == false) {
                answer += i;
            }
        }
        
        return answer;
    }
}
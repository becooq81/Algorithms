class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i =0; i < s.length(); i++) {
            String letter = s.substring(i, i+1);
            String beforeLetter = s.substring(0,i);
            int find = beforeLetter.lastIndexOf(letter);
            if (find == -1) {
                answer[i] = find;
            } else {
                answer[i] = i - find;
            }
        }
        return answer;
    }
}
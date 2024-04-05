import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int i =0; i < skip.length(); i++) {
            int idx = alphabets.indexOf(skip.charAt(i));
            alphabets = alphabets.substring(0, idx) + alphabets.substring(idx+1);
        }
        System.out.println("a"+alphabets.indexOf("a"));
        System.out.println("u"+alphabets.indexOf("u"));
        for (int i =0; i < s.length(); i++) {
            String letter = s.substring(i, i+1);
            int currentIndex = alphabets.indexOf(letter);
            int newIdx = currentIndex;
            System.out.print(letter+" ");
            if (newIdx + index < alphabets.length()) {
                answer += alphabets.charAt(newIdx + index);
            } else {
                
                newIdx = (index - (alphabets.length()-1-currentIndex)) % alphabets.length() -1;
                
                if (newIdx == -1) {
                    newIdx = alphabets.length()-1;
                }
                
                answer += alphabets.charAt(newIdx);
            }
        }
        
        return answer;
    }
}
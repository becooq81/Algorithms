import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                sb.append(s.charAt(idx));
            }
            else {
                for (String key : map.keySet()) {
                    if (key.length() + idx <= s.length()) {
                        String maybeKey = s.substring(idx, idx + key.length());
                        if (maybeKey.equals(key)) {
                            sb.append(map.get(maybeKey));
                            idx += key.length()-1;
                            break;
                        }
                    }
                }
            }
            idx += 1;
        }
        
        return Integer.parseInt(sb.toString());
    }
}
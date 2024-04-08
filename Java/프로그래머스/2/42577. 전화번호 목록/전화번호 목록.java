import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, List<String>> phones = new HashMap<>();
        int minLen = 20;
        for (String phone : phone_book) {
            minLen = Math.min(minLen, phone.length());
        }
        
        for (String phone : phone_book) {
            String prefix = phone.substring(0, minLen);
            if (!phones.containsKey(prefix)) {
                phones.put(prefix, new ArrayList<>());   
            }
            phones.get(prefix).add(phone);
        }
        
        for (String key : phones.keySet()) {
            int arrSize = phones.get(key).size();
            if (arrSize == 0) continue;
            for (int i = 0; i < arrSize; i++) {
                for (int j = 0; j < arrSize; j++) {
                    if (i == j) continue;
                    if (phones.get(key).get(i).indexOf(phones.get(key).get(j)) == 0) {
                        answer = false;
                        break;
                    }
                }
            }
        }

        
        return answer;
    }
}
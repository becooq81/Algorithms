import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        LocalDate todayDate = LocalDate.parse(today.replace('.', '-'));
        Map<String, Integer> termsMap = new HashMap<>();
        
        for (int i =0; i < terms.length; i++) {
            String type = terms[i].split(" ")[0];
            int period = Integer.parseInt(terms[i].split(" ")[1]);
            termsMap.put(type, period);
        }
        
        List<Integer> destroyList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            LocalDate startDate = LocalDate.parse(privacies[i].split(" ")[0].replace('.', '-'));
            String type = privacies[i].split(" ")[1];
            System.out.println(i+" expires " + startDate.plusMonths(termsMap.get(type)));
            int comparison = startDate.plusMonths(termsMap.get(type)).compareTo(todayDate);
            if (comparison <= 0) {
                destroyList.add(i+1);
            }
        }
        
        
        
        int[] answer = new int[destroyList.size()];
        for (int i = 0; i < destroyList.size(); i++) {
            answer[i] = destroyList.get(i);
        }
        
        return answer;
    }
}
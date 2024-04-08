import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        List<Integer> citationList = new ArrayList<>();
        for (int i =0; i < citations.length ;i++) {
            citationList.add(citations[i]);
        }
        Collections.sort(citationList);
        
        int maxCit = citationList.get(citationList.size()-1);
        //System.out.println(maxCit);
        
        for (int i = maxCit; i >= 0; i--) {
            
            //System.out.println();
            citationList.add(i);
            Collections.sort(citationList);
            //System.out.println(i);
            //System.out.println("  size: " + citationList.size());
            //System.out.println("  index: " + citationList.indexOf(i));
            if (citationList.size() - citationList.indexOf(i) - 1>= i) {
                //System.out.println("   JACKPOT");
                answer = i;
                break;
            }
            citationList.remove(Integer.valueOf(i));
        }
        
        return answer;
    }
}
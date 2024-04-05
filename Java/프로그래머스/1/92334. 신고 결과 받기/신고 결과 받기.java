import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> users = new HashMap<>();
        int[][] result = new int[id_list.length][id_list.length];
        boolean[][] iReported = new boolean[id_list.length][id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], i);
        }
        
        for (String rep : report) {
            String reporter = rep.split(" ")[0];
            String reported = rep.split(" ")[1];
            
            int reporterIdx = users.get(reporter);
            int reportedIdx = users.get(reported);
            
            if (result[reportedIdx][reporterIdx] == 0) {
                result[reportedIdx][reporterIdx] += 1;
            }
        }
        
        for (int i = 0; i < id_list.length; i ++) {
            int totalReported = 0;
            List<Integer> reporters = new ArrayList<>();
            //System.out.println(i);
            for (int j = 0; j < id_list.length; j++) {
                if (i == j) continue;
                totalReported += result[i][j];
                if (result[i][j] > 0) {
                    reporters.add(j);
                }
            }
            
            //System.out.println("  total reported: "+ totalReported);
            //System.out.print("  reporters: ");
        
            if (totalReported >= k) {
                for (int m = 0; m < reporters.size(); m++) {
                    answer[reporters.get(m)] += 1;
                }
            }
            
        }
        
        return answer;
    }
}
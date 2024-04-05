import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int xLen = X.length();
        int yLen = Y.length();
        
        String answer = "";
        
        int[] x_vals = new int[10];
        int[] y_vals = new int[10];
        for (int i = 0; i < xLen; i ++) {
            int idx = (int) X.charAt(i) - '0';
            x_vals[idx] += 1;
        }
        for (int i = 0; i < yLen; i ++) {
            int idx = (int) Y.charAt(i) - '0';
            y_vals[idx] += 1;
        }
        
        StringBuilder commons = new StringBuilder();
        int count = 0;
        for(int i = 0; i < 10; i ++) {
            int rep = Math.min(x_vals[i], y_vals[i]);
            commons.append(Integer.toString(i).repeat(rep));
            count += rep;
        }
        
        if (count == 0) {
            return "-1";
        }
        
        answer = commons.reverse().toString();
        //System.out.println("commons: "+commons.toString());
        //System.out.println("answer: "+answer);
        
        if (answer.substring(0, 1).equals("0")) {
            return "0";
        }
        
        return answer;
    }
}
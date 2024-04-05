import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winNums = new ArrayList<>();
        for (int num : win_nums) {
            winNums.add(num);
        }
        
        int count = 0;
        int zeroCount = 0;
        for (int lotto : lottos) {
            System.out.println(lotto+": "+ winNums.indexOf(lotto));
            if (winNums.indexOf(lotto) != -1) {
                count += 1;
            }
            if (lotto == 0) {
                zeroCount += 1;
            }
        }
        
        //System.out.println(count);
        //System.out.println(count+ zeroCount);
        
        int[] answer = {getRank(count + zeroCount),getRank(count)};

        return answer;
    }
    
    private int getRank(int count) {
        if (count == 6) {
            return 1;
        } else if (count == 5) {
            return 2;
        } else if (count == 4) {
            return 3;
        } else if (count == 3) {
            return 4;
        } else if (count == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = bfs(numbers, target);
        return answer;
    }
    private int bfs(int[] numbers, int target) {
        List<Integer> queue = new ArrayList<>();
        queue.add(numbers[0]);
        queue.add(numbers[0]*-1);
        
        
        int idx = 1;
        while (idx < numbers.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : queue) {
                tmp.add(num + numbers[idx]);
                tmp.add(num - numbers[idx]);
            }
            queue = tmp;
            idx += 1;
            
        }
        int ans = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == target) ans ++;
        }
        return ans;
    }
}

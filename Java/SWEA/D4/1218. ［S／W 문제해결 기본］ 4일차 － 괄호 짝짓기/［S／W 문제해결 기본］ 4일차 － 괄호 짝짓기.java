import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put('[',']');
        pairs.put('<','>');
        pairs.put('{','}');
        pairs.put('(',')');

        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean success = solve(br.readLine().toCharArray(), pairs);
            sb.append("#").append(t+1).append(" ").append(success ? 1 : 0);
            if (t != 9) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        
    }

    private static boolean solve(char[] parantheses, Map<Character, Character> pairs) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char p : parantheses) {
            if (!stack.isEmpty() && pairs.containsKey(stack.getLast()) && pairs.get(stack.getLast()) == p) {
                    stack.pollLast();
                    continue;
                
            }
            stack.addLast(p);
        }
        return stack.isEmpty();
    }
}
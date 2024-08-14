import java.util.*;
import java.io.*;

class Solution {

    static Map<Character, Character> pairs = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        pairs.put('[',']');
        pairs.put('<','>');
        pairs.put('{','}');
        pairs.put('(',')');

        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean success = solve(br.readLine().toCharArray());
            sb.append("#").append(t+1).append(" ").append(success ? 1 : 0);
            if (t != 9) sb.append("\n");
        }
        System.out.append(sb);
    }

    private static boolean solve(char[] parantheses) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char p : parantheses) {
            if (!stack.isEmpty()) {
                if (pairs.containsKey(stack.getLast()) && pairs.get(stack.getLast()) == p) {
                    stack.pollLast();
                    continue;
                }
            }
            stack.addLast(p);
        }
        return stack.isEmpty();
    }
}
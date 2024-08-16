import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            solve(deque);
            sb.append("#").append(t+1).append(" ").append(dequeToString(deque));
            if (t != 9) sb.append("\n");
        }
        System.out.append(sb);
    }

    private static void solve(ArrayDeque<Integer> deque) {
        int reduction = 1;
        while (deque.peek() > 0) {
            if (reduction > 5) reduction = 1;

            int newTail = Math.max(0, deque.pollFirst() - reduction);
            deque.addLast(newTail);
            if (newTail <= 0) break;

            reduction++;
        }
    }

    private static String dequeToString(ArrayDeque<Integer> deque) {
        StringBuilder sb = new StringBuilder();
        for (int a : deque) {
            sb.append(a).append(" ");
        }
        return sb.toString().trim();
    }


}
import java.util.*;
import java.io.*;
public class Main {
    private static final char MOVE_LEFT = '<', MOVE_RIGHT = '>', BACKSPACE = '-', NEW_LINE = '\n';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(solve(br.readLine())).append(NEW_LINE);
        }
        System.out.append(sb);
    }
    private static String solve(String input) {
        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            switch (current) {
                case MOVE_LEFT:
                    if (!left.isEmpty()) {
                        char c = left.pollLast();
                        right.addFirst(c);
                    }
                    break;
                case MOVE_RIGHT:
                    if (!right.isEmpty()) {
                        char c = right.poll();
                        left.addLast(c);
                    }
                    break;
                case BACKSPACE:
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                default:
                    left.addLast(current);
            }
        }
        return toString(left, right);
    }
    private static String toString(ArrayDeque<Character> left, ArrayDeque<Character> right) {
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.poll());
        }
        while (!right.isEmpty()) {
            sb.append(right.poll());
        }
        return sb.toString();
    }
}

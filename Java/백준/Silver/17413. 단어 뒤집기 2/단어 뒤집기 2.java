import java.util.*;
import java.io.*;

public class Main {
    private static final char OPENING_BRACKET = '<';
    private static final char CLOSING_BRACKET = '>';
    private static final char WHITESPACE = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        // System.out.println("STRING LENGTH: " + input.length);
        while (idx < input.length) {
            // System.out.printf("Outer loop) idx: %d, current char: %s\n", idx,
            // input[idx]);
            if (input[idx] == OPENING_BRACKET) {
                while (input[idx] != CLOSING_BRACKET) {
                    sb.append(input[idx++]);
                    // System.out.printf(" Brackets: idx: %d, current char: %s\n", idx, input[idx]);
                }
                sb.append(input[idx]);
                idx++;
                // System.out.printf(" Bracket closed: full string till now: %s\n",
                // sb.toString());

            } else if (input[idx] == WHITESPACE) {
                while (input[idx] == WHITESPACE) {
                    sb.append(input[idx++]);
                    // System.out.printf(" Whitespace: idx: %d, current char: %s\n", idx,
                    // input[idx]);
                }
            } else {
                while (idx < input.length && input[idx] != OPENING_BRACKET && input[idx] != WHITESPACE) {
                    // System.out.printf(" Added to stack: idx: %d, letter: %s\n", idx, input[idx]);
                    stack.push(input[idx++]);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                    // System.out.printf(" Popped from stack: full sb: %s\n", sb.toString());
                }
            }
        }
        System.out.append(sb);
    }
}
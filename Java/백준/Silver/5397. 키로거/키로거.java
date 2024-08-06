import java.util.*;
import java.io.*;

public class Main {

    private static final char MOVE_LEFT = '<', MOVE_RIGHT = '>', BACKSPACE = '-', NEW_LINE = '\n';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(solve(br.readLine().toCharArray())).append(NEW_LINE);
        }
        System.out.append(sb);
    }

    private static String solve(char[] input) {
        LinkedList<Character> ll = new LinkedList<>();
        ListIterator<Character> iterator = ll.listIterator();
        for (char c : input) {
            switch (c) {
                case MOVE_LEFT:
                    if (iterator.hasPrevious())
                        iterator.previous();
                    break;
                case MOVE_RIGHT:
                    if (iterator.hasNext())
                        iterator.next();
                    break;
                case BACKSPACE:
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(c);
            }
        }
        return toString(ll);
    }

    private static String toString(LinkedList<Character> ll) {
        StringBuilder sb = new StringBuilder();
        for (char c : ll) {
            sb.append(c);
        }
        return sb.toString();
    }
}
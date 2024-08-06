import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    private static final String WHITESPACE = " ", NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb.append((int) (Math.pow(2, N) - 1)).append(NEW_LINE);
        hanoi(N, 1, 2, 3);
        System.out.append(sb);
    }

    private static void hanoi(int numPlates, int start, int by, int dest) {
        if (numPlates == 1) {
            sb.append(start).append(WHITESPACE).append(dest).append(NEW_LINE);
            return;
        } else {
            hanoi(numPlates - 1, start, dest, by);
            sb.append(start).append(WHITESPACE).append(dest).append(NEW_LINE);
            hanoi(numPlates - 1, by, start, dest);
        }
    }
}
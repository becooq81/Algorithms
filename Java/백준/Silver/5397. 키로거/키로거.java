import java.util.*;
import java.io.*;

public class Main {

    private static final char MOVE_LEFT = '<', MOVE_RIGHT = '>', BACKSPACE = '-';

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(solvePassword(br.readLine().toCharArray())).append("\n");
        }
        System.out.append(sb);
    }

    private static String solvePassword(char[] input) {
        LinkedList<Character> output = new LinkedList<>();
        // StringBuilder output = new StringBuilder();
        int idx = 0;
        int outputIdx = 0;
        while (idx < input.length) {
            char current = input[idx];
            if (current == MOVE_LEFT) {
                outputIdx = Math.max(0, outputIdx - 1);
                // System.out.printf(" move left at: %d, outputIdx: %d\n", idx, outputIdx);
            } else if (current == MOVE_RIGHT) {
                outputIdx = Math.min(output.size(), outputIdx + 1);
                // System.out.printf(" move right at: %d, outputIdx: %d\n", idx, outputIdx);
            } else if (current == BACKSPACE) {
                if (!output.isEmpty()) {
                    // outputIdx = Math.min(output.size() - 1, outputIdx);
                    if (outputIdx != 0) {
                        output.remove(outputIdx - 1);
                        outputIdx = Math.max(0, --outputIdx);
                    }
                    // System.out.printf(" popped at: %s\n", output.toString());
                }
            } else {
                output.add(outputIdx++, current);
                outputIdx = Math.min(output.size(), outputIdx);
                // System.out.printf(" pushed at: %s\n", output.toString());
            }
            idx++;
            // System.out.printf("Output curr idx: %d, current size: %d\n", outputIdx,
            // output.size());

        }

        StringBuilder sb = new StringBuilder();
        for (char c : output)
            sb.append(c);

        return sb.toString();
    }
}
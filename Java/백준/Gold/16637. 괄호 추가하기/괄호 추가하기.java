import java.io.*;
import java.util.*;
public class Main {
    static int max = Integer.MIN_VALUE;
    static int N;
    static char[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        bruteforce(2, input[0]-'0');

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calc(int n1, char op, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                return n1 * n2;
        }
    }

    private static void bruteforce(int index, int result) {
        if (index >= N) {
            max = max > result ? max : result;
            return;
        }
        if (index + 2 < N) {
            int next = calc(input[index]-'0', input[index+1], input[index+2]-'0');
            bruteforce(index+4, calc(result, input[index-1], next));
        }
        bruteforce(index+2, calc(result, input[index-1], input[index]-'0'));
    }
}
import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        sb.append(fib(N));
        System.out.append(sb);
    }

    private static int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1 || N == 2)
            return 1;
        return fib(N - 1) + fib(N - 2);
    }
}
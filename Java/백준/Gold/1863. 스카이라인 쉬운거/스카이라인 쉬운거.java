import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peekLast() > y) {
                ans++;
                stack.pollLast();
            }
            if (stack.isEmpty() || stack.peekLast() < y) {
                stack.add(y);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pollLast() > 0) ans++;
        }

        System.out.println(ans);

        

    }

}
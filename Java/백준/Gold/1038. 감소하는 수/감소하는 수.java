import java.io.*;
import java.util.*;

public class Main {

    static int cnt;
    static List<Long> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        if (target <= 10) {
            System.out.println(target);
            return;
        } else if (target >= 1023) {
            System.out.println("-1");
            return;
        } else {
            for (int i = 0; i < 10; i++) {
                dfs(1, i);
            }
            Collections.sort(ls);
            System.out.println(ls.get(target));
        }
    }

    private static void dfs(int digit, long num) {
        if (digit > 10) return;
        ls.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs(digit + 1, num * 10 + i);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }
        
        int ans = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            char[] values = String.valueOf(i).toCharArray();
            for (int j = 0; j < values.length; j++) {
                if (broken[values[j] - '0']) {
                    break;
                } else if (j == values.length - 1) {
                    ans = Math.min(ans, Math.abs(i - N) + values.length);
                }
            }
        } 
        System.out.println(ans);


    }
}
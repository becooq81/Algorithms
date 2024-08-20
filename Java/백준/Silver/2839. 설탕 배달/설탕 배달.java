import java.io.*;
import java.util.*;

public class Main {
    static int[] kg = {3, 5};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int ans = solve(N);



        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static int solve(int N) {
        int fives = N / 5;
        for (int i = fives; i >= 0; i--) {
            if ((N - fives * 5)%3 == 0) {
                return fives + (N-fives*5)/3;
            }
            fives --;
        }
        return -1;
    }

}
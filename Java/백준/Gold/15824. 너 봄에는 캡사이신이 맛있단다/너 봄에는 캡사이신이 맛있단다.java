import java.util.*;
import java.io.*;

public class Main {

    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long max = arr[i] * (pow(2, i) - 1);
            long min = arr[i] * (pow(2, n - i - 1) - 1);
            sum = (sum + max - min + MOD) % MOD;
        }

        bw.write(Long.toString(sum));
        bw.flush();
        br.close();
    }

    private static long pow(int base, int exp) {
        long result = 1;
        long baseMod = base;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * baseMod) % MOD;
            }
            baseMod = (baseMod * baseMod) % MOD;
            exp /= 2;
        }
        return result;
    }
}
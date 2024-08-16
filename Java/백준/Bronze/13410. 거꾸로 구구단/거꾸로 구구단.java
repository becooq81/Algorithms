import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i <= K; i++) {
            Integer num = N * i;
            String str = new StringBuilder(num.toString()).reverse().toString();
            set.add(Integer.parseInt(str));
        }

        sb.append(set.pollLast());
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
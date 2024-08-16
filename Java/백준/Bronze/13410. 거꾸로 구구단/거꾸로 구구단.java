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
            ArrayDeque<Integer> ad = new ArrayDeque<>();
            for (int j = 0; j < num.toString().length(); j++) {
                ad.addFirst(num.toString().charAt(j) - '0');
            }
            String str = "";
            while (!ad.isEmpty()) {
                str += ad.pollFirst();
            }
            set.add(Integer.parseInt(str));
        }

        sb.append(set.pollLast());
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
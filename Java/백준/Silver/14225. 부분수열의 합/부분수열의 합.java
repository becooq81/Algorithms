import java.util.*;
import java.io.*;

public class Main {

    static TreeSet<Integer> ts = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ts.add(arr[i]);
        }

        generateCombinations(arr, 0, 0);
        ts.pollFirst(); // 0 제거
        int ans = 1;
        while (!ts.isEmpty()) {
            // System.out.printf("ans: %d, first: %d\n", ans, ts.first());
            if (ts.pollFirst() > ans) {
                break;
            }
            ans++;
        }
        sb.append(ans);
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void generateCombinations(int[] arr, int start, int sum) {
        ts.add(sum);
        for (int i = start; i < arr.length; i++) {
            generateCombinations(arr, i+1, sum+arr[i]);
        }
    }


    
}
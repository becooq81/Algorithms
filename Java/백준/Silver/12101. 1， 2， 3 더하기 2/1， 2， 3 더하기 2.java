import java.util.*;
import java.io.*;

public class Main {

    static TreeSet<List<Integer>> ts = new TreeSet<>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (a.get(i) > b.get(i)) return 1;
                else if (a.get(i) < b.get(i)) return -1;
            }
            return 0;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        generatePermuations(new ArrayList<>(), n);

        if (ts.size() < k) {
            sb.append(-1);
        } else {
            int i = 0;
            while (!ts.isEmpty()) {
                i++;
                if (i == k) break;
                ts.pollFirst();
            }
            List<Integer> ans = ts.pollFirst();
            for (int j = 0; j <ans.size(); j++) {
                sb.append(ans.get(j));
                if (j != ans.size()-1) sb.append("+");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    private static void generatePermuations(List<Integer> result, int n) {
        int sum = sum(result);
        if (sum >= n) {
            if (sum == n) {
                ts.add(new ArrayList<>(result));
            }
            return;
        }
        for (int i = 1; i <=3; i++) {
            result.add(i);
            generatePermuations(result, n);
            result.remove(result.size()-1);
        }
    }

    private static int sum(List<Integer> result) {
        int sum = 0;
        for (int a : result) {
            sum += a;
        }
        return sum;
    }


    
}
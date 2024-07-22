import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new ValComparator());

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            else pq.add(arr[i]);
        }
        System.out.append(sb);

    }

    static class ValComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int absComp = Integer.compare(Math.abs(o1), Math.abs(o2));
            if (absComp != 0) return absComp;
            else return Integer.compare(o1, o2);
        }


    }
}
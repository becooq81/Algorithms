import java.io.*;
import java.util.*;

public class Main {   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        TreeMap<Integer, Integer> schedule = new TreeMap<>();
        while (st.hasMoreTokens()) {
            trucks.offerLast(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int weight = 0;

        while (!trucks.isEmpty() || !schedule.isEmpty()) {
            time ++;
            if (!schedule.isEmpty() && time - schedule.firstKey() >= w) {
                weight -= schedule.pollFirstEntry().getValue();
            }
            if (!trucks.isEmpty() && weight + trucks.peek() <= L) {
                int currWeight = trucks.pollFirst();
                schedule.put(time, currWeight);
                weight += currWeight;
            }
            

        }
        sb.append(time);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

}
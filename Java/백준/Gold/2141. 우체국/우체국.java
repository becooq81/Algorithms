import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] towns = new long[N][2];
        long totalPeople = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            // 거리가 x인 마을에 a명의 사람이 산다
            long[] tmp =  {Long.parseLong(input[0]), Long.parseLong(input[1])}; 
            totalPeople += tmp[1];
            towns[i] = tmp;
        }

        Arrays.sort(towns, Comparator.comparingLong(a->a[0]));
        long currPeople = 0;
        for (long[] town : towns) {
            //System.out.printf("x: %d, a: %d, Current People: ",town[0], town[1], currPeople);
            currPeople += town[1];
            if (currPeople >= (totalPeople+1)/2) {
                System.out.println(town[0]);
                break;
            }
        }

        br.close();
    }
}
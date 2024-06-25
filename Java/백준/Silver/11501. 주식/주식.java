import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] ans = new long[t];
        for (int i = 0; i < t; i++) {
            int numElements = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] elements = new int[numElements];
            for (int j = 0; j < numElements; j++) {
                elements[j] = Integer.parseInt(input[j]);
            }

            long profit = 0;
            int tmpMaxPrice = elements[numElements-1];
            for (int j = numElements-1; j >= 0; j--) {
                if (elements[j] <= tmpMaxPrice) {
                    profit += tmpMaxPrice - elements[j];
                } else {
                    tmpMaxPrice = elements[j];
                }
            }
            ans[i] = profit;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
        br.close();
    }
}
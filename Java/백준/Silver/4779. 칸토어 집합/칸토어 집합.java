import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N;
            try {
                N = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                break;
            }
            System.out.println(divide(0, (int) Math.pow(3, N)));
        }

    }

    private static String divide(int start, int end) {
        if (end == 1)
            return "-";
        int diff = (end - start) / 3;
        int mid1 = start + diff;
        int mid2 = start + diff * 2;
        if (mid2 - mid1 == 1)
            return "- -";
        return divide(start, mid1) + " ".repeat(diff) + divide(mid2, end);
    }
}

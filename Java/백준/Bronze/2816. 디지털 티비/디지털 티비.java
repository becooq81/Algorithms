import java.io.*;
public class Main {
    private static final String FIRST = "KBS1", SEC = "KBS2";
    private static final int CURSOR_DOWN = 1, CURSOR_UP = 2, SWAP_DOWN = 3, SWAP_UP = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        int kbs1_idx = -1, kbs2_idx = -1;
        for (int i = 0; i <N; i++) {
            String channel = br.readLine();
            if (channel.equals(FIRST)) kbs1_idx = i;
            if (channel.equals(SEC)) kbs2_idx = i;
        }

        if (kbs1_idx > kbs2_idx) kbs2_idx++;
        for (int i = 0; i < kbs1_idx; i++) output.append(CURSOR_DOWN);
        for (int i =0; i < kbs1_idx; i++) output.append(SWAP_UP);
        if (kbs2_idx != 1) {
            for (int i = 0; i < kbs2_idx; i++) output.append(CURSOR_DOWN);
            for (int i =1; i < kbs2_idx; i++) output.append(SWAP_UP);
        }
        System.out.append(output);
    }
}
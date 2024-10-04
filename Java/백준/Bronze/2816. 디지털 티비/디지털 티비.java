import java.io.*;
public class Main {
    private static final String FIRST = "KBS1", SEC = "KBS2";
    private static final String CURSOR_DOWN = "1", SWAP_UP = "4";
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
        output.append(CURSOR_DOWN.repeat(kbs1_idx));
        output.append(SWAP_UP.repeat(kbs1_idx));
        if (kbs2_idx != 1) {
            output.append(CURSOR_DOWN.repeat(kbs2_idx));
            output.append(SWAP_UP.repeat(kbs2_idx-1));
        }
        System.out.append(output);
    }
}
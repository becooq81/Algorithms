import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int ans =0;
        
        for (int i = 0; i < N; i++) {
            boolean check = true;
            for (int j = i + 1; j < N; j++) {
                if (words[j].startsWith(words[i])) {
                    check = false;
                }
            }
            if (check) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
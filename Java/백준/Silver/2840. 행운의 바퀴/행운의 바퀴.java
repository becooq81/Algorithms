import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean failed = false;
        char[] wheel = new char[N];
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < N; i++) {
            wheel[i] = '?';
        }
        int idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int turn = Integer.parseInt(st.nextToken());
            char letter = st.nextToken().charAt(0);
            idx = (idx + N*100 - turn) % N;
            if ((wheel[idx] != '?' && wheel[idx] != letter) || (wheel[idx] != letter && occurrences.get(letter) != null)) {
               failed = true;
            } else {
                wheel[idx] = letter;
                occurrences.put(letter, 1);
            }
        }

        if (failed) System.out.append("!");
        else System.out.append(resultToString(wheel, idx));
        
    }

    static String resultToString(char[] wheel, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wheel.length; i++) {
            int printIdx = (idx+i) % wheel.length;
            sb.append(wheel[printIdx]);
        }
        return sb.toString();
    }
}
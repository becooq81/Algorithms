import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> order = new HashMap<>();
        Map<String, Integer> orderReverse = new HashMap<>();
        String[] pokemons = new String[N];
        for (int i = 0; i < N; i++) {
            pokemons[i] = br.readLine();
            order.put(i+1, pokemons[i]);
            orderReverse.put(pokemons[i], i+1);
        }

        Arrays.sort(pokemons);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();
            int idx = -1;
            try {
                idx = Integer.parseInt(cmd);
            } catch (Exception e) {
                
            }
            if (idx >= 0) output.append(order.get(idx));
            else output.append(orderReverse.get(cmd));

            output.append("\n");
        }
        System.out.println(output);
    }

    private static int binarySearch(String cmd, String[] pokemons) {
        int start = 0, end = pokemons.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (pokemons[mid].equals(cmd)) return mid;
            else if (pokemons[mid].compareTo(cmd) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
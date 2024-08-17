import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t= 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> categoryCount = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // skip the clothing name
                String category = st.nextToken();
                
                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            }
            
            int combinations = 1;
            for (int count : categoryCount.values()) {
                combinations *= (count + 1); // (wearing an item from this category + not wearing)
            }
            
            sb.append(combinations - 1).append("\n"); // subtract the case where no clothes are worn
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
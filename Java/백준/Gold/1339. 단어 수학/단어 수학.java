import java.io.*;
import java.util.*;

public class Main {   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                char ch = input[j];
                int value = (int) Math.pow(10, input.length - j - 1);
                map.put(ch, map.getOrDefault(ch, 0) + value);
            }
        }
        

        PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> -Integer.compare(a.value, b.value));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        int sum = 0;
        int num = 9;
        while (!nodes.isEmpty()) {
            Node entry = nodes.poll();
            // System.out.printf("%s, %d\n", entry.getValue(), entry.getKey());

            sum += entry.value * num--;
        }


        
        

		sb.append(sum);	
		bw.write(sb.toString());
		bw.flush();
		br.close();

	}

    static class Node {
        int value; 
        char c;
        Node(char c, int value) {
            this.c = c;
            this.value = value;
        } 
    }
}
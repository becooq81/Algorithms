import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Integer> queue = new LinkedList<>();
    static List<List<Integer>> routes = new ArrayList<>(); 
    static int N, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws Exception {
        
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        
        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
        
        br.close();
    }

    private static void dfs(int start) throws Exception{
        if (queue.size()==M) {
            for (int i = 0; i < M; i++) {
                sb.append(queue.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            queue.add(arr[i]);
            dfs(i+1);
            queue.removeLast();
        }
    }

}
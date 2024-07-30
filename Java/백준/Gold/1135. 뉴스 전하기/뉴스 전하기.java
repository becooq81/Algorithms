import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int mother = Integer.parseInt(input[i]);
            tree.add(new ArrayList<>());
            if (mother != -1)
                tree.get(mother).add(i);
        }
        sb.append(dfs(0));
        System.out.append(sb);
    }

    private static int dfs(int node) {
        if (tree.get(node).isEmpty())
            return 0;
        List<Integer> children = new ArrayList<>();

        for (int child : tree.get(node)) {
            children.add(dfs(child));
        }

        Collections.sort(children, Collections.reverseOrder());

        int time = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < children.size(); i++) {
            pq.add(children.get(i) + time);
            time++;
        }
        return pq.poll();
    }
}
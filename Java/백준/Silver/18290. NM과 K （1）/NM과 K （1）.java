import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> nodes = new ArrayList<>();
    static int N, M, K, maxSum = Integer.MIN_VALUE;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                nodes.add(new Node(i, j++, Integer.parseInt(st.nextToken())));
            }
        }

        generateCombinations(0, 0, new Node[K], new boolean[N*M]);
        
        sb.append(maxSum);
        br.close();
        bw.write(sb.toString());
        bw.flush();
    }

    static class Node {
        int y, x, data;
        Node (int y, int x, int data) {
            this.y = y;
            this.x = x;
            this.data = data;
        }

    }

    private static void updateMaxSum(Node[] result) {
        int sum = 0;
        for (Node a : result) {
            sum += a.data;
        }
        maxSum = Math.max(maxSum, sum);
    }

    private static void generateCombinations(int depth, int start, Node[] result, boolean[] visited) {
        if (depth == K) {
            if (noAdjacent(result)) {
                updateMaxSum(result);
            }
            return;
        }
        for (int i = start; i < N * M; i++) {
            result[depth] = nodes.get(i);
            visited[i] = true;
            generateCombinations(depth+1, i+1, result, visited);
            visited[i] = false;
        }
    }

    private static boolean noAdjacent(Node[] result) {
        for (int i = 0; i < result.length; i++) {
            Node curr = result[i];
            for (int j = 0; j < result.length; j++) {
                if (i == j) continue; 
                Node neighbor = result[j];
                for (int k = 0; k < 4; k++) {
                    int ny = dy[k] + curr.y;
                    int nx = dx[k] + curr.x;
                    if (ny == neighbor.y && nx == neighbor.x) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}
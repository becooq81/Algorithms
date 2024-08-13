import java.util.*;
import java.io.*;

public class Main {
    static final char NEW_LINE = '\n', WHITESPACE = ' ';
    static StringBuilder sb = new StringBuilder();
    static int[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];

        makePermutation(new LinkedList<>());

        System.out.append(sb);
    }

    private static void makePermutation(LinkedList<Integer> tmp) {
        if (tmp.size() == M) {
            sb.append(listToString(tmp)).append(NEW_LINE);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                tmp.addLast(i);
                visited[i] = 1;
                makePermutation(tmp);
                visited[i] = 0;
                tmp.removeLast();
            }
        }
    }

    private static String listToString(LinkedList<Integer> tmp) {
        StringBuilder sb = new StringBuilder();
        ListIterator<Integer> ll = tmp.listIterator();
        while (ll.hasNext()) {
            sb.append(ll.next()).append(WHITESPACE);
        }
        return sb.toString().trim();
    }
}
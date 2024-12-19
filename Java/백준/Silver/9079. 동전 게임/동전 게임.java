import java.io.*;
import java.util.*;

public class Main {

    static int ans;
    static final int[][][] directions = {{{0, 0}, {0, 1}, {0, 2}}, {{1, 0}, {1, 1}, {1, 2}}, {{2, 0}, {2, 1}, {2, 2}},
                        {{0, 0}, {1, 0}, {2, 0}}, {{0, 1}, {1, 1}, {2, 1}}, {{0, 2}, {1, 2}, {2, 2}},
                        {{0, 0}, {1, 1}, {2, 2}}, {{2, 0}, {1, 1}, {0, 2}}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[][] input = new char[3][3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    input[i][j] = st.nextToken().charAt(0);
                }
            }
            ans = solve(input);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

    private static int solve(char[][] input) {
        ArrayDeque<char[][]> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.addLast(input);
        visited.put(convertToString(input), 0);
        while (!queue.isEmpty()) {
            char[][] node = queue.pollFirst();

            if (isUniform(node)) return visited.get(convertToString(node));

            for (int i = 0; i < directions.length; i++) {
                char[][] current = transform(node, i);
                String v = convertToString(current);
                if (visited.containsKey(v)) continue;
                visited.put(v, visited.get(convertToString(node)) + 1);
                queue.add(current);
            }
        }
        return -1;
    }

    private static char[][] transform(char[][] input, int idx) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = input[i][j];
            }
        }

        for (int[] coord : directions[idx]) {
            int y = coord[0];
            int x = coord[1];
            copy[y][x] = copy[y][x] == 'H' ? 'T' : 'H';
        }
        return copy;
    }

    private static String convertToString(char[][] input) {
        StringBuilder temp = new StringBuilder();
        for(int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                temp.append(input[j][k]);
            }
        }
        return temp.toString();
    }

    private static boolean isUniform(char[][] input) {
        char target = input[0][0];
        for (char[] row : input) {
            for (char c : row) {
                if (c != target) return false;
            }
        }
        return true;
    }

}
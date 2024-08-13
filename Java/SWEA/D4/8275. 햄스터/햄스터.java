import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final char HASHTAG = '#', WHITESPACE = ' ', NEW_LINE = '\n';

    static int[][] conditions;
    static int N, X, M;
    static List<int[]> answers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            answers.clear();
            conditions = new int[M][3];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                conditions[i][0] = Integer.parseInt(st.nextToken());
                conditions[i][1] = Integer.parseInt(st.nextToken());
                conditions[i][2] = Integer.parseInt(st.nextToken());
            }

            solve(0, new int[N], new boolean[X+1]);

            sb.append(HASHTAG).append(t+1).append(WHITESPACE);
            
            if (answers.size()==0) sb.append(-1);
            else sb.append(arrToString(findMostOrFirstHamsters()));
            if (t != T-1) sb.append(NEW_LINE);
        }
        br.close();
        System.out.append(sb);
    }

    private static void solve(int depth, int[] tmp, boolean[] visited) {
        if (depth == N) {
            if (satisfiesConditions(tmp)) {
                answers.add(Arrays.copyOf(tmp, depth));
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            tmp[depth] = i; 
            visited[i] = true;
            solve(depth+1, tmp, visited);
            visited[i] = false;      
        }
    }

    private static boolean satisfiesConditions(int[] candidate) {
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int l = conditions[i][0]; l <= conditions[i][1]; l++) {
                sum += candidate[l-1];
            }
            if (sum != conditions[i][2]) {
                return false;
            }
        }
        return true;
    }

    private static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(WHITESPACE);
        }
        return sb.toString().trim();
    }

    private static int[] findMostOrFirstHamsters() {
        int maxIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answers.size(); i++) {
            int[] answer = answers.get(i);
            int sum = 0;
            for (int a : answer) {
                sum += a;
            }
            if (max < sum) {
                max = sum;
                maxIdx = i;
            }
        }
        return answers.get(maxIdx);
    }
}
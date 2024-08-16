import java.util.*;
import java.io.*;

class Solution {

    static int maxScore = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            maxScore = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료의 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            int[][] ingredients = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            solve(ingredients, 0, L, 0, 0);
            sb.append("#").append(t+1).append(" ").append(maxScore);
            if (t != T-1) sb.append("\n");
        }
        System.out.append(sb);
    }

    private static void solve(int[][] ingredients, int start, int L, int calories, int score) {
        maxScore = Math.max(score, maxScore);
        // System.out.println("Max score: "+maxScore);
        for (int i = start; i < ingredients.length; i++) {
            if (calories + ingredients[i][1] <= L) {
                // System.out.printf("%d번째 재료: 칼로리: %d, 점수: %d\n", i, ingredients[i][1], ingredients[i][0]);
                solve(ingredients, i+1, L, calories + ingredients[i][1], score + ingredients[i][0]);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Solution {
    static final char NEW_LINE = '\n', WHITESPACE = ' ', HASHTAG = '#';
    static final int numOfStages = 9;
    static int T;
    static int[] inyoung = new int[numOfStages], gyuyoung = new int[numOfStages];;
    static ArrayDeque<int[]> cardsPermutation = new ArrayDeque<>();
    static TreeSet<Integer> arr = new TreeSet<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr.clear();
            int idx = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                gyuyoung[idx++] = num;
                arr.add(num);
            }

            idx = 0;
            for (int j = 1; j <= 18; j++) {
                if (!arr.isEmpty() && arr.first() == j) {
                    arr.pollFirst();
                    continue;
                }
                inyoung[idx++] = j;
            }

            cardsPermutation.clear();
            solvePermutation(0, new int[numOfStages], new boolean[numOfStages]);
            
            int gyuWinCount = 0, gyuLoseCount = 0;
            for (int[] gyuCards : cardsPermutation) {
                int result = solveWhoWins(gyuCards);
                if (result == 0) gyuWinCount ++;
                else if (result == 1) gyuLoseCount ++;
            }
            sb.append(HASHTAG).append(i+1).append(WHITESPACE);
            sb.append(gyuLoseCount).append(WHITESPACE).append(gyuWinCount).append(NEW_LINE);
        }
        
        br.close();
        System.out.append(sb);
    }

    private static void solvePermutation(int idx, int[] cards, boolean[] visited) {
        if (idx == numOfStages) {
            cardsPermutation.add(Arrays.copyOf(cards, numOfStages));
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                cards[idx] = inyoung[i];
                visited[i] = true;
                solvePermutation(idx+1, cards, visited);
                visited[i] = false;
            }
        }
    }

    // 0이면 규영이가 이긴다
    // 1면 인영이가 이긴다
    // 2면 무승부
    private static int solveWhoWins(int[] perm) {
        int inScore = 0, gyuScore = 0;
        for (int i = 0; i < numOfStages; i++) {
            int stake = perm[i] + gyuyoung[i];
            if (perm[i] > gyuyoung[i]) gyuScore += stake;
            else inScore += stake;
        }
        
        if (gyuScore > inScore) return 0;
        else if (gyuScore < inScore) return 1;
        else return 2;
    }
}
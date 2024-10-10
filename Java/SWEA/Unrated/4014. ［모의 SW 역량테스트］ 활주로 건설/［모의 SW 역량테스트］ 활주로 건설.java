import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    static int N, X;
    static int[][] map;
    static int totalRunways;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            totalRunways = 0;

            for (int i = 0; i < N; i++) {
                if (canBuildRunway(map[i])) {
                    totalRunways++;
                }
            }

            for (int i = 0; i < N; i++) {
                int[] column = new int[N];
                for (int j = 0; j < N; j++) {
                    column[j] = map[j][i];
                }
                if (canBuildRunway(column)) {
                    totalRunways++;
                }
            }
            sb.append("#").append(t).append(" ").append(totalRunways).append("\n");
        }
        System.out.println(sb);
    }
    
    static boolean canBuildRunway(int[] line){
        boolean[] used = new boolean[N];
    
        for(int i = 0; i < N - 1; i++){
            if(line[i] == line[i + 1]) continue;
    
            // Uphill
            else if(line[i] + 1 == line[i + 1]){
                for(int j = 0; j < X; j++){
                    int idx = i - j;
                    if(idx < 0 || line[idx] != line[i] || used[idx]){
                        return false;
                    }
                    used[idx] = true;
                }
            }
    
            // Downhill
            else if(line[i] - 1 == line[i + 1]){
                for(int j = 1; j <= X; j++){
                    int idx = i + j;
                    if(idx >= N || line[idx] != line[i + 1] || used[idx]){
                        return false;
                    }
                    used[idx] = true;
                }
                i += X - 1; 
            }
    
            else{
                return false;
            }
        }
        return true;
    }
}

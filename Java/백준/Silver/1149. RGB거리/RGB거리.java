import java.util.*;
import java.io.*;
public class Main {

    static int N, colors[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        colors = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];
        // (i, j)는 i번째 집이 j 컬러 (0-빨강, 1-초록, 2-파랑)일 때 최소값

        for (int i = 0; i < 3; i++) {
            dp[0][i] = colors[0][i];
            // System.out.println("0번째 집을 "+ i+ " 컬러로 칠하면: "+dp[0][i]);

        }
        for (int i =1; i < N; i++) {
            for (int j =0; j < 3; j++) {
                int 현재랑_안겹치는_페인팅_최소 = Integer.MAX_VALUE;
                int idx = -1;
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        // System.out.println(k+"는 스킵");
                        continue;
                    }
                    if (현재랑_안겹치는_페인팅_최소 > dp[i-1][k]) {
                        idx = k;
                    }

                    현재랑_안겹치는_페인팅_최소 = Math.min(현재랑_안겹치는_페인팅_최소, dp[i-1][k]);
                }

                dp[i][j] = 현재랑_안겹치는_페인팅_최소+colors[i][j];
                // System.out.println((i-1)+"번째 집을 "+idx+"로 칠하면 "+현재랑_안겹치는_페인팅_최소+","+(i)+"번째 집을 "+ j+ " 컬러로 칠하면: "+dp[i][j]);
            }
        }


        int ans = Integer.MAX_VALUE;
        
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[N-1][i]);
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
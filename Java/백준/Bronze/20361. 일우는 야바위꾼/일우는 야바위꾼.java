import java.io.*;
import java.util.*;

public class Main {   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
			
		int[] cups = new int[N];
		for (int i = 0; i < N; i++) {
			cups[i] = i+1;
		}
			
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int idx1 = Integer.parseInt(st.nextToken())-1;
			int idx2 = Integer.parseInt(st.nextToken())-1;
			swap(idx1, idx2, cups);
		}
		int ans = -1;
		for (int i = 0; i < N; i++) {
			if (cups[i] == X) {
				ans = i+1;
				break;
	    	}
		}

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
    static void swap(int idx1, int idx2, int[] cups) {
        int tmp = cups[idx1];
        cups[idx1] = cups[idx2];
        cups[idx2] = tmp;
    }

}
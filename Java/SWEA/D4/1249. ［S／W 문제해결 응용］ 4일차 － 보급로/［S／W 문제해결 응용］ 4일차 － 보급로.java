import java.io.*;
import java.util.*;
public class Solution {

	static int N, map[][];
	static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1}, INF = Integer.MAX_VALUE;
	
	static int getMinDistance(int sr, int sc, int er, int ec) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // {r, c, time}
		for (int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], INF);
		}
		
		minTime[sr][sc] = 0;
		
		pq.offer(new int[] {sr, sc, minTime[sr][sc]});
		while (!pq.isEmpty()) {
			int[] stopOver = pq.poll();
			int r = stopOver[0];
			int c = stopOver[1];
			int time = stopOver[2];
			if (visited[r][c]) continue;
			visited[r][c] = true;
			if (r == er && c == ec) return time;
			for (int d = 0; d < 4; d++) {
				int nr = r + DY[d];
				int nc = c + DX[d];
				if (isValidCoordinate(nr, nc) && !visited[nr][nc] && minTime[nr][nc] > time) {
					minTime[nr][nc] = time + map[nr][nc];
					pq.offer(new int[] {nr, nc, minTime[nr][nc]});
				}
			}
		}
		return -1;
	}
	
	static boolean isValidCoordinate(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			System.out.println("#"+tc+" "+getMinDistance(0, 0, N-1, N-1)); // 좌상단 출발, 우하단 도착
		}
	}
}
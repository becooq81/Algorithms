import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static StringBuilder sb;
	static int M, N, K, grid[][];
	static boolean visited[][];
	static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1};
	
	static int bfs(int startY, int startX) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startX, startY});
		visited[startY][startX] = true;
		int count = 1;
		
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			int x = node[0];
			int y = node[1];
			// System.out.println("Start at: "+y+","+x);
			
			for (int d = 0; d < 4; d++) {
				int ny = y + DY[d];
				int nx = x + DX[d];
				// System.out.println("   Exploring: "+y+","+x);
				
				if (isValidCoordinate(nx, ny) && !visited[ny][nx] && grid[ny][nx] == 0) {
					// System.out.println("         SUccess");
					visited[ny][nx] = true;
					count ++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return count;
		
	}
	
	static boolean isValidCoordinate(int startX, int startY) {
		return startX >= 0 && startY >= 0 && startY < M && startX < N;
	}
	
	
	static void fill(int startX, int startY, int endX, int endY) {
		for (int r = startY; r < endY; r++) {
			for (int c = startX; c < endX; c++) {
				grid[r][c] =1;
			}
		}
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("-------");*/
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		grid = new int[M][N];
		visited = new boolean[M+1][N+1];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			// System.out.println(startX+" "+startY+" " + endX + " " +endY);

			fill(startX, startY, endX, endY);
		}
		
		/*for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}*/
		
		int areaCount = 0;
		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0 && !visited[i][j]) {
					// System.out.println("BFS at "+i+","+j);
					areas.add(bfs(i, j));
					areaCount++;
				}
			}
		}
		
		Collections.sort(areas);
		
		sb.append(areaCount).append("\n");
		for (int a : areas) {
			sb.append(a).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
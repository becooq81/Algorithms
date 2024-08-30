import java.util.Arrays;
import java.util.Scanner;

public class Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점 수
		int[][] adjMatrix = new int[V][V];
		boolean[] visited = new boolean[V]; // 방문여부 배열 (트리 포함 정점 배열)
	
		int[] minEdge = new int[V]; // 자신과 타 정점들 간의 간선비용 중 최소 간선 비용
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = sc.nextInt();
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; // 0번 정점을 트리의 시작정점이 되도록 함 (다른 정점이어도 상관 없음)
		int cost = 0;
		
		for (int i = 0; i < V; i++) {
			// step 1: 트리 구성에 포함될 가장 유리한 정점 선택
			// 즉, 빝츠리 정점 중 최소 비용 간선의 정점 선택
			// 즉, 최솟값 찾기
			
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < V; j++) {
				if (visited[j]) continue; // 이미 트리에 포함된 정점은 건너뛴다
				if (min > minEdge[j]) {
					minVertex = j;
					min = minEdge[j];
				}
			}
			
			if (minVertex == -1) break;
			visited[minVertex] = true;
			cost += min;
			
			// step 2: 선택된 정점과 타 정점들 간선 비용 비교하기 (간보기)
			// 이미 트리에 포함되어 있는 간선은 의미 없는 작업이다 (사이클 형성도 될 수 있음)
			for (int j = 0; j < V; j++) {
				// 비트리 정점이면서, 그 비트리의 정점의 최소 간선의 비용이 현재 선택된 정점과 자신으로의 간선 비용보다 더 크면 
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println();
	}
}

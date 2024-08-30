import java.util.*;
    import java.io.*;

    public class Main {

        static final int DY[] = {-1, 1, 0, 0}, DX[] = {0, 0, -1, 1};

        static int bfs(int N, int M, int[][] grid) {
            int[][] distance = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            distance[0][0] = 1;
            visited[0][0] = true;

            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] node = queue.pollFirst();

                if (node[0] == N-1 && node[1] == M-1) return distance[N-1][M-1];

                for (int i = 0; i < 4; i++) {
                    int ny = DY[i] + node[0];
                    int nx = DX[i] + node[1];

                    if (ny >= 0 && nx >= 0 && nx < M && ny < N && !visited[ny][nx] && grid[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        distance[ny][nx] = distance[node[0]][node[1]] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    grid[i][j] = input[j] - '0';
                }
            }


            sb.append(bfs(N, M, grid));
            bw.write(sb.toString());
            bw.flush();
            br.close();
            bw.close();
        }

    }
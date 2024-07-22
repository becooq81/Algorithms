import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree st = new SegmentTree(N);

        st.init(arr, 1, 1, N);
        for (int i = 0; i < M+K; i++) {
            String[] ip = br.readLine().split(" ");
            int cmd = Integer.parseInt(ip[0]);
            int a = Integer.parseInt(ip[1]);
            long b = Long.parseLong(ip[2]);

            if (cmd == 1) {
                st.update(1, 1, N, a, b-arr[a]);
                arr[a] = b;
            } else {
                sb.append(st.sum(1, 1, N, a, (int)b)).append("\n");
            }
        }


        System.out.append(sb);
        br.close();

    }

    static class SegmentTree {
        long[] tree;
        int treeSize;
        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.treeSize = (int) Math.pow(2, h+1);
            this.tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return this.tree[node] = arr[start];
            }
            return tree[node] = init(arr, node*2, start, (start+end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
        }

        public void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || end < idx) return;

            this.tree[node] += diff;

            if (start != end) {
                update(node*2, start, (start+end)/2, idx, diff);
                update(node*2+1, (start+end)/2+1, end, idx, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return this.tree[node];
            return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}
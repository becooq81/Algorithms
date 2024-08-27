import java.util.*;
import java.io.*;

public class Solution {

    static final int[] DY = {-1, 0, 1, 0}, DX = {0, 1, 0, -1};
    static int N, M, K;
    static Organism[] organisms;

    static void simulate() {
        for (int time = 1; time <= M; time++) {
            Map<Key, List<Organism>> presence = new HashMap<>();
            
            for (Organism o : organisms) {
                o.y += DY[o.dir];
                o.x += DX[o.dir];
                if (isDrugged(o.y, o.x)) {
                    o.count /= 2;
                    o.dir = flipDirection(o.dir);
                }
                Key key = new Key(o.y, o.x);
                presence.computeIfAbsent(key, k -> new ArrayList<>()).add(o);
            }

            for (List<Organism> list : presence.values()) {
                if (list.size() > 1) {
                    int maxCount = 0;
                    Organism survivor = null;
                    int totalCount = 0;

                    for (Organism o : list) {
                        if (o.count > maxCount) {
                            maxCount = o.count;
                            survivor = o;
                        }
                        totalCount += o.count;
                    }

                    if (survivor != null) {
                        survivor.count = totalCount;
                    }

                    for (Organism o : list) {
                        if (o != survivor) {
                            o.count = 0;
                        }
                    }
                }
            }
        }
    }

    static class Key {
        int y, x;
        Key(int y, int x) {
            this.y = y;
            this.x = x;
        }
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Key other = (Key) obj;
            return y == other.y && x == other.x;
        }
    }

    static int flipDirection(int dir) {
        return (dir + 2) % 4;
    }

    static boolean isDrugged(int y, int x) {
        return y == 0 || x == 0 || y == N - 1 || x == N - 1;
    }

    static class Organism {
        int y, x, count, dir;
        Organism(int y, int x, int count, int dir) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.dir = dir;
        }
    }

    static int translateDir(int dir) {
        switch (dir) {
            case 1: return 0; // 상
            case 2: return 2; // 하
            case 3: return 3; // 좌
            default: return 1; // 우
        }
    }

    static int sumSurviving() {
        int sum = 0;
        for (Organism o : organisms) {
            sum += o.count;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            organisms = new Organism[K];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = translateDir(Integer.parseInt(st.nextToken()));
                organisms[i] = new Organism(y, x, count, dir);
            }
            simulate();
            sb.append("#").append(t + 1).append(" ").append(sumSurviving()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
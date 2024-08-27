import java.util.*;
import java.io.*;

public class Solution {

    static final int[] DY = {-1, 0, 1, 0}, DX = {0, 1, 0, -1};
    static int N, M, K;
    static Organism[] organisms;

    static void simulate() {
        for (int time = 1; time <=M; time++) {
            Map<Key, List<Integer>> presence = new HashMap<>();
            for (int i = 0; i < organisms.length; i++) { 
                Organism o = organisms[i];
                o.y += DY[o.dir];
                o.x += DX[o.dir];
                if (isDrugged(o.y, o.x)) {
                    o.count /= 2;
                    o.dir = flipDirection(o.dir);
                }
                Key key = new Key(o.y, o.x);
                if (!presence.containsKey(key)) presence.put(key, new ArrayList<>());
                presence.get(key).add(i);
            }

            for (Map.Entry<Key, List<Integer>> entry : presence.entrySet()) {
                if (entry.getValue().size() >= 2) {
                    int survivedIdx = -1;
                    int maxCount = -1;
                    int sumCount = 0;
                    for (int idx : entry.getValue()) {
                        if (organisms[idx].count > maxCount) {
                            survivedIdx = idx;
                            maxCount = organisms[idx].count;
                        }
                        sumCount += organisms[idx].count;
                    }
                    organisms[survivedIdx].count = sumCount;

                    for (int idx : entry.getValue()) {
                        if (idx != survivedIdx) {
                            organisms[idx].count = 0;
                        }
                    }
                }
            }
        }
    }

    static class Key {
        int y, x;
        Key (int y, int x) {
            this.y = y;
            this.x = x;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + y;
            result = prime * result + x;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Key other = (Key) obj;
            if (y != other.y)
                return false;
            if (x != other.x)
                return false;
            return true;
        }
    }

    static int flipDirection(int dir) {
        return (dir + 2) % 4;
    }

    static boolean isDrugged(int y, int x) {
        return y == 0 || x == 0 || y == N-1 || x == N-1;
    }

    static class Organism {
        int y, x, count, dir; 
        Organism (int y, int x, int count, int dir) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.dir = dir;
        }
    }

    static int translateDir(int dir) {
        switch (dir) {
            case 1: // 상
                return 0;
            case 2: // 하
                return 2;
            case 3: // 좌
                return 3;
            default: // 우
                return 1;
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
            sb.append("#").append(t+1).append(" ").append(sumSurviving()).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
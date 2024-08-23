import java.io.*;
import java.util.*;
  
public class Solution {
 
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};
    static int sum, M, A;
    static int[][][] grid;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
  
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {            
            sum = 0;
            st = new StringTokenizer(br.readLine());
 
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            int[] userA = new int[M];
            int[] userB = new int[M];
            int idx = 0;
            while (st.hasMoreTokens()) {
                userA[idx++] = Integer.parseInt(st.nextToken());
            }
            idx = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                userB[idx++] = Integer.parseInt(st.nextToken());
            }
            Battery[] batteries = new Battery[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                batteries[i] = new Battery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(batteries, (a, b) -> -Integer.compare(a.performance, b.performance));
 
            idx = 0;
            for (Battery b : batteries) {
                b.order = idx++;
            }
 
            grid = new int[10][10][A];
            init(batteries);
             
            solve(userA, userB, batteries);
 
            sb.append("#").append(t+1).append(" ").append(sum);
            if (t != T-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
 
    static void solve(int[] userA, int[] userB, Battery[] batteries) {
        int xA = 0, yA = 0, xB = 9, yB = 9;
        for (int i = -1; i < userA.length; i++) {
 
            if (i != -1) {
                xA += dx[userA[i]];
                yA += dy[userA[i]];
                xB += dx[userB[i]];
                yB += dy[userB[i]];
            }
                          
            ArrayDeque<Integer> reachA = new ArrayDeque<>();
            ArrayDeque<Integer> reachB = new ArrayDeque<>();
             
            for (int batteryIdx = 0; batteryIdx < A; batteryIdx++) {
                if (reachA.size() >= 2) break;
                if (grid[yA][xA][batteryIdx] > 0) {
                    reachA.addLast(batteryIdx);
                }
            }
            for (int batteryIdx = 0; batteryIdx < A; batteryIdx++) {
                if (reachB.size() >= 2) break;
                if (grid[yB][xB][batteryIdx] > 0) {
                    reachB.addLast(batteryIdx);
                }
            }

            int tmpSum = 0;
            if (reachA.isEmpty() && reachB.isEmpty()) continue;
            if (reachA.isEmpty() && !reachB.isEmpty()) {
                tmpSum += batteries[reachB.pollFirst()].performance;
            } else if (!reachA.isEmpty() && reachB.isEmpty()) {
                tmpSum += batteries[reachA.pollFirst()].performance;
            } else {
                if (reachA.peek() != reachB.peek()) {
                    tmpSum += batteries[reachB.pollFirst()].performance + batteries[reachA.pollFirst()].performance;
                } else {
                    if (reachA.size() > reachB.size()) {
                        reachA.pollFirst();
                        tmpSum += batteries[reachB.pollFirst()].performance + batteries[reachA.pollFirst()].performance;
                    } else if (reachA.size() < reachB.size()) {
                        reachB.pollFirst();
                        tmpSum += batteries[reachB.pollFirst()].performance + batteries[reachA.pollFirst()].performance;
                    } else if (reachB.size() == 1) {
                        tmpSum += batteries[reachB.pollFirst()].performance;
                    } else if (reachB.size() == 2) {
                        reachA.pollFirst();
                        tmpSum += batteries[reachB.pollFirst()].performance + Math.max(batteries[reachA.pollFirst()].performance, batteries[reachB.pollFirst()].performance);
                    }
                }
            }
            sum += tmpSum;             
        }
    }
 
    static void init(Battery[] batteries) {
        for (int i = 0; i < batteries.length; i++) {
            Battery battery = batteries[i];
            fillManhattan(battery);
        }
    }
 
    static void fillManhattan(Battery battery) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (manhattanDistance(battery.y, battery.x, i, j) <= battery.coverage) {
                    grid[i][j][battery.order] = battery.performance;
                }
            }
        }
    }
 
    static int manhattanDistance(int y, int x, int ny, int nx) {
        return Math.abs(ny -y) + Math.abs(nx -x);
    }
     
    static class Battery {
        int y, x, coverage, performance, order;
        Battery(int x, int y, int coverage, int performance) {
            this.y = y-1;
            this.x = x-1;
            this.coverage = coverage;
            this.performance = performance;
        }
    }
}
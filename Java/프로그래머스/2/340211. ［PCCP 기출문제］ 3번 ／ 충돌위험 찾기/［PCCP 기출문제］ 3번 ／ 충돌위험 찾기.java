import java.util.*;

class Solution {
    
    static int longestPath = 0;
    
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r =r;
            this.c=c;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            Point p = (Point) o;
            if (p.r == this.r && p.c == this.c) return true;
            return false;
        }
        
        @Override
        public int hashCode() {
           return Objects.hash(r, c);
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        
        List<List<int[]>> allRoutes = new ArrayList<>();
        for (int[] route : routes) {
            allRoutes.add(findRoute(route, points));
        }
        for (int i = 0 ; i < longestPath; i++) {
            Map<Point, Integer> map = new HashMap<>();
            for (int j = 0; j < allRoutes.size();j++) {
                if (i >= allRoutes.get(j).size()) continue;
                int[] loc = allRoutes.get(j).get(i);
                Point p = new Point(loc[0], loc[1]);
                if (!map.containsKey(p)) map.put(p, 1);
                else map.put(p, map.get(p) + 1);
            }
            
            for (Map.Entry<Point, Integer> e : map.entrySet()) {
                if (e.getValue()>= 2) answer++;
            }
        }
        
        return answer;
    }
    
    private List<int[]> findRoute(int[] route, int[][] points) {
        List<int[]> path = new ArrayList<>();
        int[] way = new int[route.length];
        for (int i =0 ; i < route.length; i++) {
            way[i] = route[i] -1;
        }
        
        int y = points[way[0]][0], x = points[way[0]][1];
        path.add(new int[] {y, x});
        for (int i = 1; i < route.length; i++) {
            int nextY = points[way[i]][0], nextX = points[way[i]][1];
            int[] move = new int[2];
            while (y != nextY) {
                if (y < nextY) {
                    y ++;
                    path.add(new int[] {y, x});
                } else {
                    y --;
                    path.add(new int[] {y, x});
                }
            }
            while (x != nextX) {
                if (x < nextX) {
                    x ++;
                    path.add(new int[] {y, x});
                } else {
                    x --;
                    path.add(new int[] {y, x});
                }
            }
        }
        longestPath = Math.max(longestPath, path.size());
        return path;
    }
}
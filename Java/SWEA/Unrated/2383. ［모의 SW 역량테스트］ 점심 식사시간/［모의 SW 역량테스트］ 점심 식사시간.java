import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	static int T, N, map[][];
	static List<Person> people;
	static StairSystem s1, s2;
	static int MIN;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			people = new ArrayList<>();
			MIN = Integer.MAX_VALUE;
			s1 = null;
			s2 = null;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 1) {
						people.add(new Person(r, c));
					} else if (map[r][c] != 0){
						if (s1 == null) {
							s1 = new StairSystem(r, c, map[r][c]);
						} else {
							s2 = new StairSystem(r, c, map[r][c]);
						}
					}
				}
			}
			partialSum(0, new boolean[people.size()]);
			output.append("#").append(t).append(" ").append(MIN).append("\n");
			
		}
		bw.write(output.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void partialSum(int nth, boolean[] checked) {
		if (nth == checked.length) {
			move(checked);
			return;
		}
		checked[nth] = true;
		partialSum(nth+1, checked);
		checked[nth] = false;
		partialSum(nth + 1, checked);
	}
	
	private static void move(boolean[] checked) {
		for (int i = 0; i < checked.length; i++) {
			if (checked[i]) {
				s1.allocate(people.get(i));
			} else {
				s2.allocate(people.get(i));
			}
		}
		int s1Time = s1.move();
		int s2Time = s2.move();
		MIN = Math.min(MIN,  Math.max(s1Time, s2Time));
	}

	static class Person {
		int r, c, t;
		public Person (int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public void updateTime(StairSystem s) {
			this.t = Math.abs(this.r - s.r) + Math.abs(this.c - s.c);
		}
		
		
	}
	
	static class StairSystem {
		int r, c, k;
		List<Person> allocated = new ArrayList<>();
		List<Person> passing = new ArrayList<>();
		
		public void allocate(Person p) {
			p.updateTime(this);
			allocated.add(p);
		}
		public int move() {
			int time = 0;
			for (;!allocated.isEmpty() || !passing.isEmpty();time++) {
				// 계단에 있는 사람이 이동
				for (int i = 0; i < Math.min(3, passing.size()); i++) {
					Person p = passing.get(i);
					p.t--;
					if (p.t == 0) {
						passing.remove(i--);
					}
				}
				// 계단에 배정된 사람이 이동
				
				for (int i = 0; i < allocated.size(); i++) {
					Person p = allocated.get(i);
					p.t --;
					if (p.t == 0) {
						allocated.remove(i--);
						p.t = this.k + 1;
						passing.add(p);
					}
				}
				
			}
			return time;
		}
		public StairSystem(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;

		}
		
		
	}
}
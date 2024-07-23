import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static class Person {
		String name;
		int age;
		int idx;
		Person(int age, String name, int idx) {
			this.age = age;
			this.name= name;
			this.idx = idx;
		}
		
		@Override
		public String toString() {
			return age+" " + name;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Person> ls = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			ls.add(new Person(age, input[1], i));
		}
		
		Collections.sort(ls, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int ageComp = Integer.compare(p1.age, p2.age);
				if (ageComp != 0) return ageComp;
				return Integer.compare(p1.idx, p2.idx);
			}
		});
		
		
		
		for (int i = 0; i < N; i++) {
			sb.append(ls.get(i)).append("\n");
		}
		System.out.append(sb);
		
		br.close();
		 
	}
}
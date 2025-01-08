package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {
	public static void main(String[] args) {
		int n = 118372;
		System.out.println(solution(n));
	}

	static public long solution(long n) {
		String[] num_split = Long.toString(n).split("");
		Arrays.sort(num_split, new MySort());
		long answer = Long.parseLong(String.join("", num_split));
		return answer;
	}

	static private class MySort implements Comparator<String> { // 내림차순 정렬

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2) * -1;
		}

	}
}

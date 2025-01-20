package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] strings = { "sun", "bed", "car" };
		int n = 1;
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	static public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		for (int i = 0; i < strings.length; i++) { // Copy
			answer[i] = strings[i];
		}
		Arrays.sort(answer, new MySort(n)); // 정렬
		return answer;
	}

	static class MySort implements Comparator<String> { // n번째 글자 기준 오름차순 정렬
		int n;

		MySort(int n) {
			this.n = n;
		}

		@Override
		public int compare(String o1, String o2) {
			if (o1.charAt(this.n) == o2.charAt(this.n)) { // n번째 글자가 같으면 문자열 사전순으로
				return o1.compareTo(o2);
			}
			return o1.charAt(this.n) - o2.charAt(this.n);
		}

	}
}

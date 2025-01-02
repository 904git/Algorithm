package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.HashSet;

public class 배열의유사도 {
	public static void main(String[] args) {
		String[] s1 = { "a", "b", "c" };
		String[] s2 = { "com", "b", "d", "p", "c" };
		System.out.println(solution(s1, s2));
	}

	static public int solution(String[] s1, String[] s2) {
		int answer = 0;
		HashSet<String> h1 = new HashSet<>(Arrays.asList(s1));
		HashSet<String> h2 = new HashSet<>(Arrays.asList(s2));
		h1.retainAll(h2); // 교집합
		answer = h1.size();
		return answer;
	}

}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 잘라서배열로저장하기 {
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		System.out.println(Arrays.toString(solution(my_str, n)));
	}

	static public String[] solution(String my_str, int n) {
		int size = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1; // 배열 크기
		String[] answer = new String[size];
		for (int i = 0; i < size; i++) {
			answer[i] = my_str.substring(i * n, Math.min(i * n + n, my_str.length())); // 마지막 남은 문자열의 길이가 n보다 작으면
																						// 문자열의 끝까지만 자르기
		}
		return answer;
	}
}

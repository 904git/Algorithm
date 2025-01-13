package 프로그래머스.Lv0;

import java.util.Arrays;

public class 문자개수세기 {
	public static void main(String[] args) {
		String my_string = "Programmers";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	static public int[] solution(String my_string) {
		int[] answer = new int[52];
		for (int i = 0; i < my_string.length(); i++) {
			if (Character.isUpperCase(my_string.charAt(i))) { // 대문자이면 인덱스 0부터
				answer[my_string.charAt(i) - 'A'] += 1;
			} else { // 소문자이면 인덱스 26부터
				answer[my_string.charAt(i) - 'a' + 26] += 1;
			}
		}
		return answer;
	}
}

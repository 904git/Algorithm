package 프로그래머스.Lv0;

import java.util.Arrays;

public class 세개의구분자 {
	public static void main(String[] args) {
		String myStr = "baconlettucetomato";
		System.out.println(Arrays.toString(solution(myStr)));
	}

	static public String[] solution(String myStr) {
		String[] answer = { "EMPTY" }; // 빈 배열이면 "EMPTY" 만 출력
		String[] str_split = myStr.split("[abc]"); // a, b, c로 문자열 분할
		int size = 0;
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].length() > 0) { // 빈 문자열 빼고 개수 카운트
				size += 1;
			}
		}
		if (size > 0) {
			answer = new String[size];
			for (int i = 0, idx = 0; i < str_split.length; i++) {
				if (str_split[i].length() > 0) { // 빈 문자열 빼고 삽입
					answer[idx++] = str_split[i];
				}
			}
		}
		return answer;
	}
}

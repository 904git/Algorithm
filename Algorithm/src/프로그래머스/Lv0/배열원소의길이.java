package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열원소의길이 {
	public static void main(String[] args) {
		String[] strlist = { "We", "are", "the", "world!" };
		System.out.println(Arrays.toString(solution(strlist)));
	}

	static public int[] solution(String[] strlist) {
		int[] answer = new int[strlist.length];
		for (int i = 0; i < strlist.length; i++) {
			answer[i] = strlist[i].length(); // String.length() 함수로 문자열 길이 측정
		}
		return answer;
	}

}

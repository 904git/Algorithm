package 프로그래머스.Lv1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		char[] alpha = s.toCharArray();
		Arrays.sort(alpha); // 오름차순 정렬
		for (int i = 0; i < alpha.length; i++) {
			sb.append(alpha[alpha.length - 1 - i]); // 거꾸로 삽입
		}
		answer = sb.toString();
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class ad제거하기 {
	public static void main(String[] args) {
		String[] strArr = { "and", "notad", "abcd" };
		System.out.println(Arrays.toString(solution(strArr)));
	}

	static public String[] solution(String[] strArr) {
		String[] answer = {};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].contains("ad")) { // ad가 들어가지 않은 문자열만 추가
				sb.append(strArr[i] + " ");
			}
		}
		answer = sb.toString().split(" "); // 공백으로 나눔
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열에서문자열대소문자변환하기 {
	public static void main(String[] args) {
		String[] strArr = { "AAA", "BBB", "CCC", "DDD" };
		System.out.println(Arrays.toString(solution(strArr)));
	}

	static public String[] solution(String[] strArr) {
		String[] answer = new String[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			if (i % 2 == 0) { // 짝수번째 인덱스
				answer[i] = toLowerCase(strArr[i]); // 소문자로 변환
			} else { // 홀수번째 인덱스
				answer[i] = toUpperCase(strArr[i]); // 대문자로 변환
			}
		}
		return answer;
	}

	// String의 모든 문자를 대문자로 변환
	static public String toUpperCase(String str) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			result.append(Character.toUpperCase(str.charAt(i)));
		}
		return result.toString();
	}

	// String의 모든 문자를 소문자로 변환
	static public String toLowerCase(String str) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			result.append(Character.toLowerCase(str.charAt(i)));
		}
		return result.toString();
	}

}

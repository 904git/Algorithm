package 프로그래머스.Lv0;

import java.util.Arrays;

public class 문자열잘라서정렬하기 {
	public static void main(String[] args) {
		String myString = "axbxcxdx";
		System.out.println(Arrays.toString(solution(myString)));
	}

	static public String[] solution(String myString) {
		String[] str_split = myString.split("x");
		Arrays.sort(str_split); // 사전순으로 정렬
		int size = 0; // 빈 문자열을 제외한 배열 크기
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].length() > 0) {
				size += 1;
			}
		}
		String[] answer = new String[size];
		for (int i = 0, idx = 0; i < str_split.length; i++) {
			if (str_split[i].length() > 0) { // 빈 문자열 빼고 저장
				answer[idx++] = str_split[i];
			}
		}
		return answer;
	}
}

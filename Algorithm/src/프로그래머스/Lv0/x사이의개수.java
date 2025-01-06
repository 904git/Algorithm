package 프로그래머스.Lv0;

import java.util.Arrays;

public class x사이의개수 {
	public static void main(String[] args) {
		String myString = "oxooxoxxox";
		System.out.println(Arrays.toString(solution(myString)));
	}

	static public int[] solution(String myString) {
		String[] str_split = myString.split("x", -1); // 끝에 길이가 0인 문자열도 포함될 수 있도록 옵션 추가
		int[] answer = new int[str_split.length];
		for (int i = 0; i < str_split.length; i++) {
			answer[i] = str_split[i].length();
		}
		return answer;
	}
}

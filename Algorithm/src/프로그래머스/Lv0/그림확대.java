package 프로그래머스.Lv0;

import java.util.Arrays;

public class 그림확대 {
	public static void main(String[] args) {
		String[] picture = { ".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...",
				"....x...." };
		int k = 2;
		System.out.println(Arrays.toString(solution(picture, k)));

	}

	static public String[] solution(String[] picture, int k) {
		String[] answer = new String[picture.length * k]; // 길이 k배
		for (int i = 0, idx = 0; i < picture.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < picture[i].length(); j++) {
				for (int c = 0; c < k; c++) {
					sb.append(picture[i].charAt(j)); // k배 늘린 문자열
				}
			}
			for (int c = 0; c < k; c++) {
				answer[idx++] = sb.toString(); // k번 삽입
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.Arrays;

public class 이진변화반복하기 {
	public static void main(String[] args) {
		String s = "110010101001";
		System.out.println(Arrays.toString(solution(s)));
	}

	static public int[] solution(String s) {
		int[] answer = { 0, 0 };
		String temp = s;
		while (!temp.equals("1")) {
			int zeroCnt = 0; // 제거할 0 개수
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '0') { // 0 개수 카운트
					zeroCnt += 1;
				}
			}
			answer[1] += zeroCnt;
			int nextNum = temp.length() - zeroCnt; // 다음 이진 문자열이 될 수
			temp = Integer.toBinaryString(nextNum); // 이진 변환
			answer[0] += 1; // 변환 횟수 증가
		}
		return answer;
	}
}

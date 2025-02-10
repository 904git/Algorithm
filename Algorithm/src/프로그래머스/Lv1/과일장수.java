package 프로그래머스.Lv1;

import java.util.Arrays;

public class 과일장수 {
	public static void main(String[] args) {
		int k = 3, m = 4;
		int[] score = { 1, 2, 3, 1, 2, 3, 1 };
		System.out.println(solution(k, m, score));
	}

	static public int solution(int k, int m, int[] score) {
		int answer = 0;
		Arrays.sort(score); // 오름차순 정렬
		for (int i = score.length - m; i >= 0; i -= m) { // 뒤에서부터 박스 포장
			answer += score[i] * m;
		}
		return answer;
	}
}

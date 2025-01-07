package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열만들기1 {
	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		System.out.println(Arrays.toString(solution(n, k)));
	}

	static public int[] solution(int n, int k) {
		int[] answer = new int[n / k];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = k * (i + 1);
		}
		return answer;
	}
}

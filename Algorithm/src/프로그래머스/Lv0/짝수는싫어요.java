package 프로그래머스.Lv0;

import java.util.Arrays;

public class 짝수는싫어요 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(int n) {
		int[] answer = new int[n / 2 + n % 2]; // 1부터 n까지 홀수의 수 = n / 2 + n % 2
		for (int i = 0; i < answer.length; i++) {
			answer[i] = 2 * i + 1; // 홀수 삽입
		}
		return answer;
	}

}

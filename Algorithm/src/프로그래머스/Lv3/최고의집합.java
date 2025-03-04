package 프로그래머스.Lv3;

import java.util.Arrays;

public class 최고의집합 {
	public static void main(String[] args) {
		int n = 2;
		int s = 9;
		System.out.println(Arrays.toString(solution(n, s)));
	}

	static public int[] solution(int n, int s) {
		int[] answer = new int[n];
		for (int i = 0; i < answer.length; i++) {
			if (s / n < 1) { // n개의 자연수 합으로 s 못 만듦
				answer = new int[1];
				answer[0] = -1;
				break;
			}
			answer[i] = s / n; // 중앙에 가까운 수의 곱이 최대
			s -= answer[i];
			n -= 1;
		}
		return answer;
	}
}

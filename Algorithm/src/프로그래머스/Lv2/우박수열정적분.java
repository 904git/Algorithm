package 프로그래머스.Lv2;

import java.util.Arrays;

public class 우박수열정적분 {
	public static void main(String[] args) {
		int k = 3;
		int[][] ranges = { { 0, 0 }, { 1, -2 }, { 3, -3 } };
		System.out.println(Arrays.toString(solution(k, ranges)));
	}

	static public double[] solution(int k, int[][] ranges) {
		double[] answer = new double[ranges.length];
		double[] collatz = new double[200]; // 우박 수열
		double[] area = new double[200]; // 누적 넓이
		int idx = 0;
		while (idx < collatz.length) {
			if (idx != 0) {
				area[idx] = area[idx - 1] + (k - collatz[idx - 1]) / 2 + collatz[idx - 1];
			}
			collatz[idx++] = k;
			if (k % 2 == 0) { // 짝수이면 나누기 2
				k = k / 2;
			} else if (k != 1) { // 홀수이면 곱하기 3 더하기 1
				k = k * 3 + 1;
			} else { // 1이면 종료
				break;
			}
		}
		for (int i = 0; i < ranges.length; i++) {
			int start = ranges[i][0]; // 시작 범위
			int end = (idx - 1) + ranges[i][1]; // 끝 범위
			if (end < start || idx <= start || idx <= end) { // 유효하지 않은 구간
				answer[i] = -1;
			} else { // 유효 구간
				answer[i] = area[end] - area[start];
			}
		}
		return answer;
	}
}

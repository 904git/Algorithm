package 프로그래머스.Lv2;

import java.util.Arrays;

public class 뒤에있는큰수찾기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 1, 2, 3, 5 };

		// 11, 10, 11, 10, 11, 10, 11, 11, 11, 12, 12, 12, -1
		System.out.println(Arrays.toString(solution2(numbers)));
	}

	static public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		answer[answer.length - 1] = -1; // 맨 끝 숫자는 조건을 만족하는 수가 없음
		for (int i = numbers.length - 2; 0 <= i; i--) { // 뒤에서부터 탐색
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) { // j번째 수가 현재 수보다 크면
					answer[i] = numbers[j];
					break;
				} else if (numbers[i] < answer[j] || answer[j] == -1) {
					// j번째 수의 뒷 큰수가 현재 수보다 크면, 그 수가 현재 수의 뒷 큰수
					// j번째 수의 뒷 큰수가 없으면, 현재 수의 뒷 큰수도 없음 (j번째 수는 이미 현재 수보다 작으므로)
					answer[i] = answer[j];
					break;
				}
			}
		}
		return answer;
	}

	static public int[] solution2(int[] numbers) { // 시간 초과
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);
		for (int i = numbers.length - 1; 0 <= i; i--) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					answer[i] = numbers[j];
					break;
				}
			}
		}
		return answer;
	}
}

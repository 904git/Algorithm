package 프로그래머스.Lv2;

import java.util.Arrays;

public class 연속된부분수열의합 {
	public static void main(String[] args) {
		int[] sequence = { 1, 2, 3, 4, 5 };
		int k = 7;
		System.out.println(Arrays.toString(solution(sequence, k)));
	}

	static public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int length = Integer.MAX_VALUE; // 부분 수열의 길이
		int left = 0, right = -1, sum = 0; // 부분 수열의 첫 인덱스, 끝 인덱스, 합
		while (true) {
			if (sum == k && right - left < length) { // 수열의 합이 k이면서 부분 수열 길이가 짧을 때
				length = right - left;
				answer[0] = left;
				answer[1] = right;
			}

			if (sum < k) { // 수열의 합이 작은 때
				right += 1;
				if (right == sequence.length) { // 수열 범위 확인
					break;
				}
				sum += sequence[right];
			} else { // 수열의 합이 클 때
				sum -= sequence[left];
				left += 1;
				if (left == sequence.length) { // 수열 범위 확인
					break;
				}
			}
		}
		return answer;
	}
}

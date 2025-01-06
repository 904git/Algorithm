package 프로그래머스.Lv0;

import java.util.Arrays;

public class 조건에맞게수열변환하기3 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		int k = 3;
		System.out.println(Arrays.toString(solution(arr, k)));
	}

	static public int[] solution(int[] arr, int k) {
		int[] answer = new int[arr.length];
		if (k % 2 != 0) { // 홀수이면
			for (int i = 0; i < arr.length; i++) {
				answer[i] = arr[i] * k; // 곱
			}
		} else { // 짝수이면
			for (int i = 0; i < arr.length; i++) {
				answer[i] = arr[i] + k; // 합
			}
		}
		return answer;
	}
}

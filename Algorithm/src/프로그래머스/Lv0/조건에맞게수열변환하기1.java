package 프로그래머스.Lv0;

import java.util.Arrays;

public class 조건에맞게수열변환하기1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (50 <= arr[i] && arr[i] % 2 == 0) { // 50보다 크거나 같은 짝수면 나누기 2
				answer[i] = arr[i] / 2;
			} else if (arr[i] < 50 && arr[i] % 2 != 0) { // 50보다 작은 홀수면 곱하기 2
				answer[i] = arr[i] * 2;
			} else { // 둘 다 아니면 그대로 삽입
				answer[i] = arr[i];
			}
		}
		return answer;
	}

}

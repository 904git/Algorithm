package 프로그래머스.Lv1;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}

	static public int[] solution(int[] arr, int divisor) {
		Arrays.sort(arr); // 오름차순 정렬
		boolean[] isPos = new boolean[arr.length]; // i번째 수가 divisor로 나누어 떨어지는 수인지 확인
		int size = 0; // divisor로 나누어 떨어지는 수의 개수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) { // i번째 수가 divisor로 나누어 떨어지면
				isPos[i] = true;
				size += 1;
			}
		}
		int[] answer = { -1 };
		if (size > 0) {
			answer = new int[size];
			for (int i = 0, idx = 0; i < isPos.length; i++) {
				if (isPos[i]) {
					answer[idx++] = arr[i];
				}
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열의길이에따라다른연산하기 {
	public static void main(String[] args) {
		int[] arr = { 49, 12, 100, 276, 33 };
		int n = 27;
		System.out.println(Arrays.toString(solution(arr, n)));
	}

	static public int[] solution(int[] arr, int n) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
			if (i % 2 != arr.length % 2) { // 길이가 홀수이면 짝수 인덱스에, 길이가 짝수이면 홀수 인덱스에 n만큼 더하기
				answer[i] += n;
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열의길이를2의거듭제곱으로만들기 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		int size = 1;
		while (size < arr.length) { // arr의 길이보다 큰 2의 거듭제곱 만들기
			size *= 2;
		}
		int[] answer = new int[size];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열두배만들기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	static public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			answer[i] = numbers[i] * 2; // i번째 값 * 2
		}
		return answer;
	}

}

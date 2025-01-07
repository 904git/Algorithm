package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열회전시키기 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		String direction = "right";
		System.out.println(Arrays.toString(solution(numbers, direction)));
	}

	static public int[] solution(int[] numbers, String direction) {
		int[] answer = new int[numbers.length];
		if (direction.equals("right")) { // 오른쪽 이동
			for (int i = 0; i < numbers.length - 1; i++) {
				answer[i + 1] = numbers[i];
			}
			answer[0] = numbers[numbers.length - 1];
		} else { // 왼쪽 이동
			for (int i = 0; i < numbers.length - 1; i++) {
				answer[i] = numbers[i + 1];
			}
			answer[answer.length - 1] = numbers[0];
		}
		return answer;
	}
}

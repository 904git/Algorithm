package 프로그래머스.Lv0;

import java.util.Arrays;

public class PCCE기출문제_6번_가채점 {
	public static void main(String[] args) {
		int[] numbers = { 1 };
		int[] our_score = { 100 };
		int[] score_list = { 100, 80, 90, 84, 20 };
		System.out.println(Arrays.toString(solution(numbers, our_score, score_list)));
	}

	static public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
		int num_student = numbers.length;
		String[] answer = new String[num_student];

		for (int i = 0; i < num_student; i++) {
			if (our_score[i] == score_list[numbers[i] - 1]) { // 수정
				answer[i] = "Same";
			} else {
				answer[i] = "Different";
			}
		}

		return answer;
	}
}

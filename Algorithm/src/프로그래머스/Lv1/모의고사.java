package 프로그래머스.Lv1;

import java.util.Arrays;

public class 모의고사 {
	public static void main(String[] args) {
		int[] answers = { 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(solution(answers)));
	}

	static public int[] solution(int[] answers) {
		int[][] guess = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] score = new int[3];
		for (int i = 0; i < answers.length; i++) { // 점수 계산
			if (answers[i] == guess[0][i % guess[0].length]) { // 1번 수포자
				score[0]++;
			}
			if (answers[i] == guess[1][i % guess[1].length]) { // 2번 수포자
				score[1]++;
			}
			if (answers[i] == guess[2][i % guess[2].length]) { // 3번 수포자
				score[2]++;
			}
		}
		int size = 0, maxScore = 0;
		for (int i = 0; i < score.length; i++) {
			if (maxScore < score[i]) {
				size = 1;
				maxScore = score[i];
			} else if (maxScore == score[i]) {
				size++;
			}
		}
		int[] answer = new int[size];
		for (int i = 0, idx = 0; i < score.length; i++) {
			if (score[i] == maxScore) {
				answer[idx++] = i + 1;
			}
		}
		return answer;
	}
}

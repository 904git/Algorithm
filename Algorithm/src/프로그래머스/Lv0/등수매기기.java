package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 등수매기기 {
	public static void main(String[] args) {
		int[][] score = { { 80, 70 }, { 70, 80 }, { 30, 50 }, { 90, 100 }, { 100, 90 }, { 100, 100 }, { 10, 30 } };
		System.out.println(Arrays.toString(solution(score)));
	}

	static public int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		int[][] student = new int[score.length][2];
		for (int i = 0; i < score.length; i++) {
			student[i][0] = score[i][0] + score[i][1];
			student[i][1] = i;
		}
		Arrays.sort(student, new MySort()); // 점수 내림차순 정렬
		for (int i = 0, rank = 1, preScore = 0; i < student.length; i++) {
			if (preScore != student[i][0]) { // 이전 등수의 점수와 현재 점수가 같지 않으면
				preScore = student[i][0]; // 점수 교체
				rank = i + 1; // 등수 계산 (앞에 같은 등수의 학생이 여러명일 수도 있음)
				answer[student[i][1]] = rank;
			} else {
				answer[student[i][1]] = rank;
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 이차원 배열 내림차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o2[0] - o1[0];
		}

	}
}

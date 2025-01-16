package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 직사각형넓이구하기 {
	public static void main(String[] args) {
		int[][] dots = { { 1, 1, }, { 2, 1 }, { 2, 2 }, { 1, 2 } };
		System.out.println(solution(dots));
	}

	static public int solution(int[][] dots) {
		int answer = 0;
		Arrays.sort(dots, new MySort()); // 좌표 정렬
		answer = (dots[2][0] - dots[0][0]) * (dots[1][1] - dots[0][1]); // 가로 * 세로
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 이차원 배열 오름차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}
}

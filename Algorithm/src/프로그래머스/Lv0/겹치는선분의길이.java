package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 겹치는선분의길이 {
	public static void main(String[] args) {
		int[][] lines = { { 0, 1 }, { 2, 5 }, { 3, 9 } };
		System.out.println(solution(lines));
	}

	static public int solution(int[][] lines) {
		int answer = 0;
		Arrays.sort(lines, new MySort()); // 오름차순 정렬
		int left = lines[0][0], right = lines[0][1];
		for (int i = 1; i < lines.length; i++) {
			if (lines[i][0] < right) { // 겹침
				answer += Math.min(right, lines[i][1]) - Math.max(left, lines[i][0]);
				left = Math.min(right, lines[i][1]);
				right = Math.max(right, lines[i][1]);
			} else {
				left = lines[i][0];
				right = lines[i][1];
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}
}

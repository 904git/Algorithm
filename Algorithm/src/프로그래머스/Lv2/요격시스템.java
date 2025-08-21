package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {
	public static void main(String[] args) {
		int[][] targets = { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } };
		System.out.println(solution(targets));
	}

	static public int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, new MySort()); // 미사일 오름차순 정렬
		int point = -1;
		for (int i = 0; i < targets.length; i++) {
			if (point <= targets[i][0]) { // 이전에 쏜 미사일에 걸쳐지지 않는 범위
				answer += 1;
				point = targets[i][1];
			} else {
				point = Math.min(point, targets[i][1]);
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 이차원 배열 오름차순 정렬

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

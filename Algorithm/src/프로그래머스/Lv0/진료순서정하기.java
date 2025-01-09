package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 진료순서정하기 {
	public static void main(String[] args) {
		int[] emergency = { 3, 76, 24 };
		System.out.println(Arrays.toString(solution(emergency)));
	}

	static public int[] solution(int[] emergency) {
		int[] answer = new int[emergency.length];
		int[][] order = new int[emergency.length][2];
		for (int i = 0; i < emergency.length; i++) {
			order[i][0] = i; // 환자 인덱스
			order[i][1] = emergency[i]; // 환자 응급도
		}
		Arrays.sort(order, new MySort()); // 내림차순 정렬
		for (int i = 0; i < order.length; i++) {
			answer[order[i][0]] = i + 1; // 응급도 순서
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 응급도 내림차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {

			return o2[1] - o1[1];
		}

	}
}

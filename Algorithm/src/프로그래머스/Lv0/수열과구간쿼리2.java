package 프로그래머스.Lv0;

import java.util.Arrays;

public class 수열과구간쿼리2 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 4, 3 };
		int[][] queries = { { 0, 4, 2 }, { 0, 3, 2 }, { 0, 2, 2 } };
		System.out.println(Arrays.toString(solution(arr, queries)));
	}

	static public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];
		for (int q = 0; q < queries.length; q++) {
			int min = Integer.MAX_VALUE;
			for (int i = queries[q][0]; i <= queries[q][1]; i++) {
				if (queries[q][2] < arr[i]) { // k보다 크면서
					min = Math.min(min, arr[i]); // 가장 작은 arr[i]
				}
			}
			if (min == Integer.MAX_VALUE) { // 답이 존재하지 않으면
				answer[q] = -1;
			} else {
				answer[q] = min;
			}
		}
		return answer;
	}
}

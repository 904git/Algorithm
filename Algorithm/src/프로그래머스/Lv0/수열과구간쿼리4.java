package 프로그래머스.Lv0;

import java.util.Arrays;

public class 수열과구간쿼리4 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 4, 3 };
		int[][] queries = { { 0, 4, 1 }, { 0, 3, 2 }, { 0, 3, 3 } };
		System.out.println(Arrays.toString(solution(arr, queries)));
	}

	static public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}

		for (int q = 0; q < queries.length; q++) {
			for (int i = queries[q][0]; i <= queries[q][1]; i++) {
				if (i % queries[q][2] == 0) {
					answer[i] += 1;
				}
			}
		}
		return answer;
	}
}

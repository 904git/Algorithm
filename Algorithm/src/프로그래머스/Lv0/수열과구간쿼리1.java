package 프로그래머스.Lv0;

import java.util.Arrays;

public class 수열과구간쿼리1 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[][] queries = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
		System.out.println(Arrays.toString(solution(arr, queries)));
	}

	static public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[arr.length];
		// arr 복사
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) { // 구간안에 있는 원소 +1
				answer[j] += 1;
			}
		}
		return answer;
	}
}

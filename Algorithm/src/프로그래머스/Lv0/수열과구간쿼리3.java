package 프로그래머스.Lv0;

import java.util.Arrays;

public class 수열과구간쿼리3 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[][] queries = { { 0, 3 }, { 1, 2 }, { 1, 4 } };
		System.out.println(Arrays.toString(solution(arr, queries)));
	}

	static public int[] solution(int[] arr, int[][] queries) {
		int[] answer = arr;
		for (int i = 0; i < queries.length; i++) {
			int temp = answer[queries[i][0]];
			answer[queries[i][0]] = answer[queries[i][1]];
			answer[queries[i][1]] = temp;
		}
		return answer;
	}
}

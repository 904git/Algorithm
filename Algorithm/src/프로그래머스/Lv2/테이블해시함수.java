package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 테이블해시함수 {
	public static void main(String[] args) {
		int[][] data = { { 2, 2, 6 }, { 1, 5, 10 }, { 4, 2, 9 }, { 3, 8, 3 } };
		int col = 2, row_being = 2, row_end = 3;
		System.out.println(solution(data, col, row_being, row_end));
	}

	static public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;
		Arrays.sort(data, new MySort(col - 1)); // [2] col 기준으로 정렬
		for (int i = row_begin; i <= row_end; i++) { // S_i
			int mod = 0;
			for (int j = 0; j < data[i - 1].length; j++) {
				mod += data[i - 1][j] % i; // [3] 각 컬럼을 i로 나눈 나머지의 합
			}
			answer = answer ^ mod; // [4] bitwise XOR
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 정렬
		int col;

		MySort(int col) {
			this.col = col;
		}

		@Override
		public int compare(int[] o1, int[] o2) { // 튜플 정렬
			// TODO Auto-generated method stub
			if (o1[col] == o2[col]) {
				return o2[0] - o1[0]; // 첫 번째 컬럼 기준으로 내림차순
			}
			return o1[col] - o2[col]; // col번째 컬럼 기준으로 오름차순
		}

	}
}

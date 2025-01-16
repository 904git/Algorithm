package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Comparator;

public class 전국대회선발고사 {
	public static void main(String[] args) {
		int[] rank = { 3, 7, 2, 5, 4, 6, 1 };
		boolean[] attendance = { false, true, true, true, true, false, false };
		System.out.println(solution(rank, attendance));
	}

	static public int solution(int[] rank, boolean[] attendance) {
		int answer = 0;
		int[][] db = new int[rank.length][2];
		for (int i = 0; i < rank.length; i++) { // 학생들의 {등수, 번호} 정보
			db[i][0] = rank[i];
			db[i][1] = i;
		}
		Arrays.sort(db, new MySort()); // 등수 순으로 정렬
		for (int i = 0, score = 10000; i < rank.length && score >= 1; i++) {
			if (attendance[db[i][1]]) { // 등수가 높은 순서대로 학생이 참석 가능하면
				answer += score * db[i][1];
				score /= 100;
			}
		}
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

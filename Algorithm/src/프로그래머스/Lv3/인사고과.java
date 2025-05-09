package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 인사고과 {
	public static void main(String[] args) {
		int[][] scores = { { 2, 2, }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 } };
		System.out.println(solution(scores));
	}

	static public int solution(int[][] scores) {
		int answer = 1;
		int[] wanho = scores[0];
		Arrays.sort(scores, new MySort());
		int max = 0;
		for (int i = 0; i < scores.length; i++) {
			if (wanho[0] < scores[i][0] && wanho[1] < scores[i][1]) { // 완호가 인센티브를 받지 못함
				return -1;
			}

			if (max <= scores[i][1]) {
				max = scores[i][1];
				if (scores[i][0] + scores[i][1] > wanho[0] + wanho[1]) { // 완호보다 점수 높은 사람
					answer += 1; // 등수 증가
				}
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
			return o2[0] - o1[0];
		}

	}
}

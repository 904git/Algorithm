package 프로그래머스.Lv2;

public class 땅따먹기 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(solution(land));
	}

	static int solution(int[][] land) {
		int answer = 0;
		int[][] sum = new int[land.length][4]; // 누적 합
		for (int i = 0; i < 4; i++) {
			sum[0][i] = land[0][i];
		}
		for (int i = 1; i < land.length; i++) { // 땅따먹기 시작
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (j != k) {
						sum[i][j] = Math.max(sum[i][j], sum[i - 1][k] + land[i][j]); // (i, j)에 오는데 얻을 수 있는 점수의 최댓값
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, sum[land.length - 1][i]); // 누적 합의 최댓값
		}
		return answer;
	}
}

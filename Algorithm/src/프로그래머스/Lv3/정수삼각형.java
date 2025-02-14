package 프로그래머스.Lv3;

public class 정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(triangle));
	}

	static public int solution(int[][] triangle) {
		int answer = 0;
		int[][] sum = new int[triangle.length][]; // triangle 층별 합
		int[] dj = { -1, 0 }; // 왼쪽, 오른쪽에서 더해짐
		for (int i = 0; i < triangle.length; i++) {
			sum[i] = new int[triangle[i].length];
			for (int j = 0; j < triangle[i].length; j++) {
				sum[i][j] = triangle[i][j];
				for (int d = 0; d < dj.length; d++) {
					int nj = j + dj[d];

					if (0 <= (i - 1) && 0 <= nj && nj < sum[i - 1].length) { // 범위 확인
						sum[i][j] = Math.max(sum[i][j], triangle[i][j] + sum[i - 1][nj]);
					}
				}
			}
		}
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < sum[sum.length - 1].length; i++) { // 마지막 층에서 최댓값 찾기
			answer = Math.max(answer, sum[sum.length - 1][i]);
		}
		return answer;
	}

	static public int solution2(int[][] triangle) {
		int answer = 0;
		int[][] sum = new int[triangle.length + 1][]; // triangle 층별 합
		int[] dj = { -1, 0 }; // 왼쪽, 오른쪽에서 더해짐
		sum[0] = new int[1];
		for (int i = 1; i <= triangle.length; i++) {
			sum[i] = new int[triangle[i - 1].length];
			for (int j = 0; j < triangle[i - 1].length; j++) {
				for (int d = 0; d < dj.length; d++) {
					int nj = j + dj[d];

					if (0 <= i - 1 && 0 <= nj && nj < sum[i - 1].length) { // 범위 확인
						sum[i][j] = Math.max(sum[i][j], triangle[i - 1][j] + sum[i - 1][nj]);
					}
				}
			}
		}
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < sum[sum.length - 1].length; i++) { // 마지막 층에서 최댓값 찾기
			answer = Math.max(answer, sum[sum.length - 1][i]);
		}
		return answer;
	}
}

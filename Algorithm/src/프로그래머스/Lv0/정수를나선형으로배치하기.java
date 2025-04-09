package 프로그래머스.Lv0;

public class 정수를나선형으로배치하기 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) {
		int n = 4;
		int[][] answer = solution(n);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	static public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		for (int i = 1, x = 0, y = 0, d = 0; i <= n * n; i++) { // 나선형 배치
			answer[x][y] = i;

			int nx = x + di[d];
			int ny = y + dj[d];
			if (nx < 0 || n <= nx || ny < 0 || n <= ny || answer[nx][ny] != 0) { // 다음 위치가 범위를 벗어나거나 이미 채워진 자리이면
				d = (d + 1) % di.length; // 방향 전환
			}
			x += di[d];
			y += dj[d];
		}
		return answer;
	}
}

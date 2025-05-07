package 프로그래머스.Lv3;

public class 파괴되지않은건물 {
	public static void main(String[] args) {
		int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
		int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
		System.out.println(solution(board, skill));
	}

	static public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int N = board.length, M = board[0].length;
		int[][] sum = new int[N + 1][M + 1];
		for (int i = 0; i < skill.length; i++) {
			if (skill[i][0] == 1) { // 공격
				sum[skill[i][1]][skill[i][2]] -= skill[i][5];
				sum[skill[i][1]][skill[i][4] + 1] += skill[i][5];
				sum[skill[i][3] + 1][skill[i][2]] += skill[i][5];
				sum[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
			} else { // 회복
				sum[skill[i][1]][skill[i][2]] += skill[i][5];
				sum[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
				sum[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
				sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
			}
		}
		// 누적 합
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				sum[i][j] += sum[i][j - 1];
			}
		}
		for (int j = 0; j < M; j++) {
			for (int i = 1; i < N; i++) {
				sum[i][j] += sum[i - 1][j];
			}
		}
		// 파괴되지 않은 건물 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (0 < board[i][j] + sum[i][j]) {
					answer += 1;
				}
			}
		}
		return answer;
	}

	static public int solution2(int[][] board, int[][] skill) { // 시간 초과
		int answer = 0;
		for (int i = 0; i < skill.length; i++) {
			for (int x = skill[i][1]; x <= skill[i][3]; x++) {
				for (int y = skill[i][2]; y <= skill[i][4]; y++) {
					if (skill[i][0] == 1) { // 공격
						board[x][y] -= skill[i][5];
					} else {// 회복
						board[x][y] += skill[i][5];
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (0 < board[i][j]) {
					answer += 1;
				}
			}
		}
		return answer;
	}
}

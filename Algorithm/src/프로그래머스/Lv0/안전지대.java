package 프로그래머스.Lv0;

public class 안전지대 {
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 시계방향 8방향

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		int answer = 0;
		int cnt = 0; // 위험지역 칸 수
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) { // 지뢰 위치이면
					cnt += 1;
					for (int d = 0; d < di.length; d++) { // 8방향 위험지역 표시
						int ni = i + di[d];
						int nj = j + dj[d];

						if (0 <= ni && ni < board.length && 0 <= nj && nj < board[i].length && board[ni][nj] == 0) {
							board[ni][nj] = -1;
							cnt += 1;
						}
					}
				}
			}
		}
		answer = board.length * board[0].length - cnt; // 안전지대 칸 수
		return answer;
	}
}

package 프로그래머스.Lv1;

public class PCCE기출문제_9번_이웃한칸 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) {
		String[][] board = { { "blue", "red", "orange", "red" }, { "red", "red", "blue", "orange" },
				{ "blue", "orange", "red", "red" }, { "orange", "orange", "red", "blue" } };
		int h = 1, w = 1;
		System.out.println(solution(board, h, w));
	}

	static public int solution(String[][] board, int h, int w) {
		int answer = 0;
		for (int d = 0; d < di.length; d++) { // 4방향 탐색
			int ni = h + di[d];
			int nj = w + dj[d];

			// 범위 확인, 같은 색인지 확인
			if (0 <= ni && ni < board.length && 0 <= nj && nj < board[0].length && board[ni][nj].equals(board[h][w])) {
				answer += 1;
			}
		}
		return answer;
	}
}

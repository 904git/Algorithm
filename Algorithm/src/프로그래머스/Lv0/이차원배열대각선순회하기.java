package 프로그래머스.Lv0;

public class 이차원배열대각선순회하기 {
	public static void main(String[] args) {
		int[][] board = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
		int k = 2;
		System.out.println(solution(board, k));
	}

	static public int solution(int[][] board, int k) {
		int answer = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i + j <= k) { // i + j가 k 이하인 경우만 합하기
					answer += board[i][j];
				}
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	static public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>(); // 바구니
		for (int i = 0; i < moves.length; i++) {
			int idx = 0;
			while (idx < board.length && board[idx][moves[i] - 1] == 0) { // 크레인 하강
				idx += 1;
			}
			if (idx < board.length) { // 집을 인형이 있을때
				if (!basket.isEmpty() && basket.peek() == board[idx][moves[i] - 1]) { // 바구니 맨 위에 담긴 인형과 같은 인형을 집었으면
					answer += 2; // 인형 터트리기
					basket.pop(); // 바구니에서 인형 제거
				} else { // 인형 터트리기 실패
					basket.add(board[idx][moves[i] - 1]); // 바구니에 인형 추가
				}
				board[idx][moves[i] - 1] = 0; // 보드에서 인형 제거
			}
		}
		return answer;
	}
}

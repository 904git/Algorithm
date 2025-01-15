package 프로그래머스.Lv0;

import java.util.Arrays;

public class 캐릭터의좌표 {
	static int[] di = { 0, 0, -1, 1 }, dj = { 1, -1, 0, 0 }; // up down left right

	public static void main(String[] args) {
		String[] keyinput = { "left", "right", "up", "right", "right" };
		int[] board = { 11, 11 };
		System.out.println(Arrays.toString(solution(keyinput, board)));
	}

	static public int[] solution(String[] keyinput, int[] board) {
		int[] answer = { 0, 0 };
		for (int i = 0, d = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("up")) {
				d = 0;
			} else if (keyinput[i].equals("down")) {
				d = 1;
			} else if (keyinput[i].equals("left")) {
				d = 2;
			} else {
				d = 3;
			}

			// 다음에 이동할 위치
			int ni = answer[0] + di[d];
			int nj = answer[1] + dj[d];

			// 범위 확인
			if (-1 * board[0] / 2 <= ni && ni <= board[0] / 2 && -1 * board[1] / 2 <= nj && nj <= board[1] / 2) {
				answer[0] = ni;
				answer[1] = nj;
			}
		}
		return answer;
	}
}

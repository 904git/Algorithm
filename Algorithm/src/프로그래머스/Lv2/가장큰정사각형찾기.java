package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 가장큰정사각형찾기 {
	static int[] di = { 0, -1, -1 }, dj = { -1, -1, 0 }; // 시계방향 3방향 (좌 좌상, 상)
//	static int[] di = { 0, 1, 1 }, dj = { 1, 1, 0 }; // 시계방향 3방향 (우, 우하, 하)

	public static void main(String[] args) {
		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		int answer = 0;
		int N = board.length, M = board[0].length;
		int[][] square = new int[N][M]; // 정사각형 한 변의 길이 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					boolean flag = true;
					int min = Integer.MAX_VALUE;
					for (int d = 0; d < di.length; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni < 0 || N <= ni || nj < 0 || M <= nj || board[ni][nj] == 0) { // 정사각형 x
							flag = false;
							break;
						} else { // 정사각형 (한 변의 길이는 3방향 중 가장 작은 것)
							min = Math.min(min, square[ni][nj]);
						}
					}
					if (!flag) {
						square[i][j] = board[i][j];
					} else { // 정사각형 최대 길이
						square[i][j] = min + 1;
					}
					answer = Math.max(answer, square[i][j] * square[i][j]);
				}
			}
		}
		return answer;
	}

	static public int solution2(int[][] board) { // 시간 초과
		int answer = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) { // 정사각형 크기 확인
					answer = Math.max(answer, getSquareSize(i, j, board));
				}
			}
		}
		return answer;
	}

	static public int getSquareSize(int i, int j, int[][] board) { // bfs로 정사각형 크기 확인
		int result = 1; // 정사각형 한 변의 길이
		int N = board.length, M = board[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[board.length][board[0].length]; // 방문 확인
		boolean flag = true; // 정사각형인지 확인
		queue.add(new int[] { i, j });
		visit[i][j] = true;
		while (!queue.isEmpty() && flag) { // bfs
			int size = queue.size();
			for (int s = 0; s < size && flag; s++) {
				int[] p = queue.poll();

				for (int d = 0; d < di.length; d++) { // 3방향 확인
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (ni < 0 || N <= ni || nj < 0 || M <= nj || board[ni][nj] == 0) { // 정사각형 x
						flag = false;
						break;
					} else if (!visit[ni][nj] && board[ni][nj] == 1) {
						queue.add(new int[] { ni, nj });
						visit[ni][nj] = true;
					}
				}
			}
			if (flag) { // 정사각형이면 길이 증가
				result += 1;
			}
		}
		return result * result; // 정사각형 넓이
	}
}

package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 혼자서하는틱택토 {
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 8방향

	public static void main(String[] args) {
		String[] board = { "OXO", "XOX", ".OX" };
		System.out.println(solution(board));
	}
	
	/*
	 * O의 개수가 x보다 작거나 차이가 1보다 크면 실패
	 * O가 완성되었을 때 x의 개수가 같으면 실패
	 * X가 완성되었을 때 O의 개수가 크면 실패
	 */
	static public int solution(String[] board) {
		int answer = 1;
		int[] cnt = new int[2]; // O와 X의 개수
		boolean[] line = new boolean[2]; // O, X 줄 완성
		int[][] map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) { // O, X 개수 카운팅
				if (board[i].charAt(j) == 'O') {
					cnt[0] += 1;
					map[i][j] = 1;
				} else if (board[i].charAt(j) == 'X') {
					cnt[1] += 1;
					map[i][j] = -1;
				}
			}
		}
		// 가로, 세로, 대각선 줄 확인
		int[] diagonal = new int[2];
		for (int i = 0; i < 3; i++) {
			int[] score = new int[2];
			for (int j = 0; j < 3; j++) {
				score[0] += map[i][j]; // 가로
				score[1] += map[j][i]; // 세로
				if (i == j) { // 오른쪽 대각
					diagonal[0] += map[i][j];
				}
				if (i + j == 2) { // 왼쪽 대각
					diagonal[1] += map[i][j];
				}
			}
			if (score[0] == 3 || score[1] == 3) { // O 완성
				line[0] = true;
			} else if (score[0] == -3 || score[1] == -3) { // X 완성
				line[1] = true;
			}
		}
		if (diagonal[0] == 3 || diagonal[1] == 3) { // O 완성
			line[0] = true;
		} else if (diagonal[0] == -3 || diagonal[1] == -3) { // X 완성
			line[1] = true;
		}
		if (cnt[0] < cnt[1] || 1 < cnt[0] - cnt[1] || (line[0] && cnt[0] == cnt[1]) || (line[1] && cnt[1] < cnt[0])) {
			answer = 0;
		}
		return answer;
	}

	static public int solution2(String[] board) { // 실패
		int[] cnt = { 0, 0 }; // O의 개수, X의 개수
		Queue<int[]> queue = new LinkedList<>(); // 줄이 완성되었는지 확인
		boolean[][] visit = new boolean[3][3]; // 방문 기록
		boolean flag = false; // 한 줄이 완성되었는지
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) != '.') {
					if (board[i].charAt(j) == 'O') {
						cnt[0] += 1;
					} else {
						cnt[1] += 1;
					}

					if (!flag) {
						queue.add(new int[] { i, j });
						visit[i][j] = true;
						int t = 0;
						while (!queue.isEmpty()) {
							int size = queue.size();
							for (int s = 0; s < size; s++) {
								int[] p = queue.poll();

								for (int d = 0; d < di.length; d++) {
									int ni = p[0] + di[d];
									int nj = p[1] + dj[d];

									if (0 <= ni && ni < 3 && 0 <= nj && nj < 3 && !visit[ni][nj]
											&& board[ni].charAt(nj) == board[i].charAt(j)) {
										// 범위 안에 있으며 아직 방문하지 않고 같은 문자일 때 bfs
										queue.add(new int[] { ni, nj });
										visit[ni][nj] = true;
									}
								}
							}
							t += 1;
						}
						if (t == 3) { // 한 줄이 완성됨
							flag = true;
						}
					}
				}
			}
		}
		if ((cnt[0] != cnt[1] && cnt[1] + 1 != cnt[0]) || (flag && cnt[0] + cnt[1] < 9)) {
			// 순서가 잘못되거나 (O의 개수가 X보다 1개 크거나 같아야 함), 한 줄이 완성되었는데 게임이 안 끝났을 때
			return 0;
		}
		return 1;
	}
}

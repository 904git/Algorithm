package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록 {
	static int[] di = { 0, 0, 1, 1 }, dj = { 0, 1, 1, 0 }; // 2x2 블럭

	public static void main(String[] args) {
		int m = 4, n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(m, n, board));
	}

	static public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
		while (true) {
			// 터지는 블럭 탐색
			List<int[]> remove_block = new ArrayList<>(); // 터지는 블록 위치 저장
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != ' ') { // 빈 블록이 아닐때
						int cnt = 0;
						for (int d = 0; d < di.length; d++) { // 2x2 블록 확인
							int ni = i + di[d];
							int nj = j + dj[d];

							if (ni < m && nj < n && map[i][j] == map[ni][nj]) {
								cnt += 1;
							}
						}

						if (cnt == 4) { // 터지는 블록
							remove_block.add(new int[] { i, j });
						}
					}
				}
			}

			if (remove_block.size() == 0) { // 터지는 블록이 없으면
				break; // 종료
			}

			// 블록 터트리기
			for (int i = 0; i < remove_block.size(); i++) {
				int[] p = remove_block.get(i);
				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (map[ni][nj] != ' ') {
						map[ni][nj] = ' '; // 블록 지우기
						answer += 1;
					}
				}
			}
			// 블록 내리기
			for (int i = m - 1; 0 < i; i--) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == ' ') { // 현재 빈공간 이면
						int idx = i - 1;
						while (0 <= idx && map[idx][j] == ' ') { // 빈공간이 아닌 블록이 나올때까지 올라가기
							idx -= 1;
						}
						if (0 <= idx) { // 내릴 블록이 있으면
							map[i][j] = map[idx][j]; // 위에 있는 블록 내리기
							map[idx][j] = ' '; // 원래 있던 블록 자리 빈 공간으로 표시
						}
					}
				}
			}
		}
		return answer;
	}
}

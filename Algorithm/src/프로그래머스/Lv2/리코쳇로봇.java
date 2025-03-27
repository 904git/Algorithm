package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) {
		String[] board = { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." };
		System.out.println(solution(board));
	}

	static public int solution(String[] board) {
		int answer = -1;
		int N = board.length, M = board[0].length(); // 맵 크기
		int[][] map = new int[N][M]; // 맵
		int[] robot = {}, goal = {}; // 로봇과 도착지 위치 정보
		for (int i = 0; i < N; i++) { // 맵 초기화
			for (int j = 0; j < M; j++) {
				if (board[i].charAt(j) == 'D') { // 장애물
					map[i][j] = 1;
				} else if (board[i].charAt(j) == 'R') { // 로봇 위치
					robot = new int[] { i, j };
				} else if (board[i].charAt(j) == 'G') { // 도착지
					goal = new int[] { i, j };
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>(); // bfs
		boolean[][][] visit = new boolean[N][M][4]; // 방문 확인
		boolean flag = false; // 도착했는지 확인
		int cnt = 0; // 이동 횟수
		queue.add(new int[] { robot[0], robot[1], 0 });

		while (!queue.isEmpty() && !flag) { // bfs
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();

				if (p[0] == goal[0] && p[1] == goal[1]) { // 도착하면 반복문 중단
					flag = true;
					break;
				}

				for (int d = 0; d < di.length; d++) { // 4방향 탐색
					int[] next = sliding(N, M, p[0], p[1], d, map); // 다음에 도착할 지점

					if (!visit[next[0]][next[1]][d]) { // 아직 방문하지 않은 곳이면
						queue.add(new int[] { next[0], next[1], d });
						visit[next[0]][next[1]][d] = true;
					}
				}
			}
			cnt += 1;
		}
		if (flag) { // 도착 성공
			answer = cnt - 1;
		}
		return answer;
	}

	static public int[] sliding(int N, int M, int i, int j, int d, int[][] map) { // 슬라이딩해서 도착할 지점 반환
		int ni = i;
		int nj = j;

		while (0 <= ni + di[d] && ni + di[d] < N && 0 <= nj + dj[d] && nj + dj[d] < M
				&& map[ni + di[d]][nj + dj[d]] != 1) { // 다음 지점 범위와 장애물 확인
			ni += di[d];
			nj += dj[d];
		}

		return new int[] { ni, nj };
	}
}

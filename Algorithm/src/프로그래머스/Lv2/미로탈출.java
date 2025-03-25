package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) {
		String[] maps = { "SOOOL", "XXOXX", "XXOOE" };
		// SOOOL
		// XXOXX
		// XXOOE
		System.out.println(solution(maps));
	}

	static public int solution(String[] maps) {
		int answer = 0;
		int N = maps.length, M = maps[0].length(); // 맵 크기
		int[][] map = new int[N][M]; // 맵
		int[] start = {}, end = {}, lever = {};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i].charAt(j) != 'X') {
					map[i][j] = 1;
					if (maps[i].charAt(j) == 'S') { // 시작 지점
						start = new int[] { i, j };
					} else if (maps[i].charAt(j) == 'E') { // 출구 지점
						end = new int[] { i, j };
					} else if (maps[i].charAt(j) == 'L') { // 레버 지점
						lever = new int[] { i, j };
					}
				}
			}
		}
		int cnt = bfs(N, M, map, start, lever); // 시작 지점에서 레버 지점까지
		if (cnt < 0) { // 도착 못하면 탈출 실패
			answer = -1;
		} else {
			answer += cnt;
			cnt = bfs(N, M, map, lever, end); // 레버 지점에서 출구 지점가지
			if (cnt < 0) { // 도착 못하면 탈출 실패
				answer = -1;
			} else {
				answer += cnt;
			}
		}
		return answer;
	}

	static public int bfs(int N, int M, int[][] map, int[] start, int[] end) { // start에서 end까지 가는 최소 거리
		int cnt = 0; // 거리
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M]; // 방문 확인
		queue.add(start); // 시작
		visit[start[0]][start[1]] = true;
		boolean flag = false;
		while (!queue.isEmpty() && !flag) { // 아직 도착하지 않았을 때까지
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();
				if (p[0] == end[0] && p[1] == end[1]) { // 끝에 도착하면 반복문 종료
					flag = true;
					break;
				}

				for (int d = 0; d < di.length; d++) { // 4방향 탐색
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					// 범위 확인, 방문 확인, 통로 확인
					if (0 <= ni && ni < N && 0 <= nj && nj < M && !visit[ni][nj] && map[ni][nj] == 1) {
						queue.add(new int[] { ni, nj });
						visit[ni][nj] = true;
					}
				}
			}
			cnt += 1;
		}
		if (flag) { // 도착지에 도착했으면
			return cnt - 1;
		}
		return -1; // 도착 실패
	}
}

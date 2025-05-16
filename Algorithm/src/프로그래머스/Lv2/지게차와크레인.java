package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 지게차와크레인 {
	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 }; // 상우하좌

	public static void main(String[] args) {
		String[] storage = { "AAAAA", "ABCDA", "AGAEA", "AZAFA", "ZYAAA" };
		String[] requests = { "BB", "DD", "Z", "Y", "Z", "G", "C", "E", "F" };
		System.out.println(solution(storage, requests));
	}

	static public int solution(String[] storage, String[] requests) {
		int N = storage.length, M = storage[0].length();
		int answer = N * M;
		int[][] map = new int[N + 2][M + 2]; // 외곽선 추가 및 숫자로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = storage[i].charAt(j) - 'A' + 1;
			}
		}
		Queue<int[]> rm_containers = new LinkedList<>(); // 꺼낼 컨테이너 좌표 정보
		for (int r = 0; r < requests.length; r++) {
			int target = requests[r].charAt(0) - 'A' + 1;
			if (1 < requests[r].length()) { // 크레인 사용해서 모든 위치에 있는 타켓 컨테이너 제거
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (map[i][j] == target) {
							map[i][j] = -1;
							rm_containers.add(new int[] { i, j });
							answer -= 1;
						}
					}
				}
			} else { // 외곽에 있는 타겟 컨테이너만 제거
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < M + 2; j++) {
						if (map[i][j] == target && checkOutline(i, j, map)) {
							map[i][j] = -1;
							rm_containers.add(new int[] { i, j });
							answer -= 1;
						}
					}
				}
			}
			// 외부와 맞닿아있는 위치 갱신
			boolean[][] visit = new boolean[N + 2][M + 2]; // 방문 확인
			while (!rm_containers.isEmpty()) {
				int size = rm_containers.size();
				for (int s = 0; s < size; s++) {
					int[] p = rm_containers.poll(); // 제거한 컨테이너의 위치가

					if (checkOutline(p[0], p[1], map)) { // 외부와 맞닿아 있었다면
						map[p[0]][p[1]] = 0; // 외곽으로 표시
						visit[p[0]][p[1]] = true;

						for (int d = 0; d < di.length; d++) { // 인접한 위치 중 비어있는 곳이 있다면 너비탐색(bfs)
							int ni = p[0] + di[d];
							int nj = p[1] + dj[d];

							if (!visit[ni][nj] && map[ni][nj] == -1) {
								rm_containers.add(new int[] { ni, nj });
							}
						}
					}
				}
			}
		}
		return answer;
	}

	static public boolean checkOutline(int i, int j, int[][] map) {
		int N = map.length, M = map[0].length;
		for (int d = 0; d < di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (0 <= ni && ni < N && 0 <= M && nj < M && map[ni][nj] == 0) {
				return true;
			}
		}
		return false;
	}

	static public int solution2(String[] storage, String[] requests) {
		int N = storage.length, M = storage[0].length();
		int answer = N * M;
		boolean[][] containers = new boolean[N + 2][M + 2]; // 공간에 컨테이너가 있는지
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				containers[i][j] = true;
			}
		}
		for (int r = 0; r < requests.length; r++) {
			int target = requests[r].charAt(0);
			if (1 < requests[r].length()) { // 크레인 사용해서 꺼내기
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (containers[i][j] && storage[i - 1].charAt(j - 1) == target) { // 모든 컨테이너 다 꺼내기
							containers[i][j] = false;
							answer -= 1;
						}
					}
				}
			} else { // 외부에서 접근 가능한 컨테이너만 꺼내기
				boolean[][] out = getOutline(containers); // 외부에 맞닿아있는지
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (containers[i][j] && storage[i - 1].charAt(j - 1) == target && checkPoint(i, j, out)) {
							containers[i][j] = false;
							answer -= 1;
						}
					}
				}
			}
		}
		return answer;
	}

	static public boolean[][] getOutline(boolean[][] containers) {
		Queue<int[]> queue = new LinkedList<>();
		int N = containers.length, M = containers[0].length;
		boolean[][] visit = new boolean[N][M];
		queue.add(new int[] { 0, 0 });
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < di.length; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];

				if (0 <= ni && ni < N && 0 <= nj && nj < M) {
					if (!visit[ni][nj] && !containers[ni][nj]) {
						queue.add(new int[] { ni, nj });
						visit[ni][nj] = true;
					}
				}
			}
		}
		return visit;
	}

	static public boolean checkPoint(int i, int j, boolean[][] out) { // 외부에서 접근이 가능한지
		int N = out.length, M = out[0].length;
		for (int d = 0; d < di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni < 0 || N <= ni || nj < 0 || M <= nj || out[ni][nj]) { // 접근 가능
				return true;
			}
		}
		return false;
	}
}

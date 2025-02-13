package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 4방향 (우하좌상)

	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(solution(maps));
	}

	static public int solution(int[][] maps) {
		int answer = 0;
		int n = maps.length, m = maps[0].length;
		Queue<int[]> queue = new LinkedList<>(); // BFS
		boolean[][] visit = new boolean[n][m]; // 방문 확인
		queue.add(new int[] { 1, 1 }); // 처음 좌표
		visit[0][0] = true;
		boolean arrive = false; // 도착했는지 확인
		while (!queue.isEmpty() && !arrive) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll(); // 현재 좌표
				if (p[0] == n && p[1] == m) { // 도착지에 도착했으면 끝
					arrive = true;
					break;
				}
				for (int d = 0; d < di.length; d++) { // 4방향 탐색
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (ni >= 1 && ni <= n && nj >= 1 && nj <= m && !visit[ni - 1][nj - 1]
							&& maps[ni - 1][nj - 1] == 1) {
						// 다음 좌표가 범위 내에 있으며 방문한 적 없고 벽이 아닌 길일 때
						queue.add(new int[] { ni, nj });
						visit[ni - 1][nj - 1] = true;
					}
				}
			}
			answer += 1;
		}
		if (!arrive) { // 도착하지 못하면 -1
			answer = -1;
		}
		return answer;
	}
}

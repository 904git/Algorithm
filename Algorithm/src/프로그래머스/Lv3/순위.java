package 프로그래머스.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] result = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(n, result));
	}

	static public int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] win = new boolean[n + 1][n + 1];
		boolean[][] lose = new boolean[n + 1][n + 1];
		for (int i = 0; i < results.length; i++) {
			win[results[i][0]][results[i][1]] = true; // 승자 정보
			lose[results[i][1]][results[i][0]] = true; // 패자 정보
		}
		for (int i = 1; i <= n; i++) { // bfs
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];
			int cnt = 0;
			queue.add(i);
			visit[i] = true;

			while (!queue.isEmpty()) { // 날 이기는 선수 수
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					int p = queue.poll();

					for (int j = 1; j <= n; j++) {
						if (!visit[j] && win[p][j]) {
							queue.add(j);
							visit[j] = true;
							cnt += 1;
						}
					}
				}
			}
			queue.add(i);
			while (!queue.isEmpty()) { // 나에게 지는 선수 수
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					int p = queue.poll();

					for (int j = 1; j <= n; j++) {
						if (!visit[j] && lose[p][j]) {
							queue.add(j);
							visit[j] = true;
							cnt += 1;
						}
					}
				}
			}

			if (cnt == n - 1) { // 이기고 지는 선수의 수가 n-1이면 내 순위 알 수 있음
				answer += 1;
			}
		}
		return answer;
	}
}

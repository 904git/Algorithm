package 프로그래머스.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 1, 1, 0, 0 } };
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int N = board.length; // 맵 크기
		int[][][] cost = new int[N][N][di.length]; // 도로 건설 비용
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < di.length; d++) {
					cost[i][j][d] = Integer.MAX_VALUE;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0 }); // i, j, d
		for (int d = 0; d < di.length; d++) {
			cost[0][0][d] = 0;
		}
		// 도착지에서부터 출발
		while (!queue.isEmpty()) { // bfs
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < N && board[ni][nj] != 1) { // 갈 수 있으면
						int next_cost = cost[p[0]][p[1]][p[2]] + 100; // 다음 지역까지 연결하는데 드는 비용
						next_cost = (!(p[0] == 0 && p[1] == 0) && d != p[2]) ? next_cost + 500 : next_cost; // 코너이면 추가비용
						if (next_cost <= cost[ni][nj][d]) { // 현재 비용이 더 적거나 같은 비용이면 계속 건설
							queue.add(new int[] { ni, nj, d });
							cost[ni][nj][d] = next_cost;
						}
					}
				}
			}
		}
		for (int d = 0; d < di.length; d++) {
			answer = Math.min(answer, cost[N - 1][N - 1][d]);
		}
		return answer;
	}
}

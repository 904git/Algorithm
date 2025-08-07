package 프로그래머스.Lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PCCP기출문제_2번_석유시추 {
	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 }; // 상우하좌

	public static void main(String[] args) {
		int[][] land = { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } };
		System.out.println(solution(land));
	}

	static public int solution(int[][] land) {
		int answer = 0;
		int N = land.length, M = land[0].length;
		HashMap<Integer, Integer> hash = new HashMap<>();
		int[][] map = new int[N][M]; // 석유 번호 표시
		boolean[][] visit = new boolean[N][M]; // 방문 확인

		for (int i = 0, idx = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (land[i][j] == 1 && !visit[i][j]) { // 방문 안 한 석유
					int cnt = 0;
					visit[i][j] = true;
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });

					while (!queue.isEmpty()) {
						int[] p = queue.poll();
						cnt += 1;
						map[p[0]][p[1]] = idx;
						for (int d = 0; d < di.length; d++) {
							int ni = p[0] + di[d];
							int nj = p[1] + dj[d];

							if (0 <= ni && ni < N && 0 <= nj && nj < M && land[ni][nj] == 1 && !visit[ni][nj]) {
								visit[ni][nj] = true;
								queue.add(new int[] { ni, nj });
							}
						}
					}
					hash.put(idx, cnt); // 석유 번호: 석유량
					idx += 1;
				}
			}
		}
		for (int j = 0; j < M; j++) {
			HashSet<Integer> set = new HashSet<>(); // 계산한 석유 번호
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (0 < map[i][j] && !set.contains(map[i][j])) { // 아직 계산하지 않은 석유 번호이면
					set.add(map[i][j]);
					sum += hash.get(map[i][j]);
				}
			}
			answer = Math.max(answer, sum);
		}
		return answer;
	}
}

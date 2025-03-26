package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도여행 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상

	public static void main(String[] args) {
		String[] maps = { "X591X", "X1X5X", "X231X", "1XXX1" };
		System.out.println(Arrays.toString(solution(maps)));
	}

	static public int[] solution(String[] maps) {
		int[] answer = { -1 };
		int N = maps.length, M = maps[0].length(); // 지도 크기
		boolean[][] visit = new boolean[N][M]; // 방문 확인
		List<Integer> days = new ArrayList<>(); // 무인도별 생존 일수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && maps[i].charAt(j) != 'X') { // 무인도 탐색
					Queue<int[]> queue = new LinkedList<>();
					int day = 0;
					queue.add(new int[] { i, j });
					visit[i][j] = true;

					while (!queue.isEmpty()) { // bfs
						int size = queue.size();
						for (int s = 0; s < size; s++) {
							int[] p = queue.poll();
							day += maps[p[0]].charAt(p[1]) - '0'; // 생존 일수 증가

							for (int d = 0; d < di.length; d++) { // 4방향 탐색
								int ni = p[0] + di[d];
								int nj = p[1] + dj[d];

								if (0 <= ni && ni < N && 0 <= nj && nj < M && !visit[ni][nj]
										&& maps[ni].charAt(nj) != 'X') { // 범위 안에 있고, 아직 방문한 적 없으며, 땅일 때
									queue.add(new int[] { ni, nj });
									visit[ni][nj] = true;
								}
							}
						}
					}
					days.add(day);
				}
			}
		}
		if (0 < days.size()) { // 무인도 있을 때만
			Collections.sort(days); // 오름차순 정렬
			answer = new int[days.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = days.get(i);
			}
		}
		return answer;
	}
}

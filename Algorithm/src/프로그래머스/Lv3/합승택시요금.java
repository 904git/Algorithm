package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 합승택시요금 {
	public static void main(String[] args) {
		int n = 6;
		int s = 4, a = 6, b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
		System.out.println(solution(n, s, a, b, fares));
	}

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < fares.length; i++) {
			dist[fares[i][0]][fares[i][1]] = fares[i][2];
			dist[fares[i][1]][fares[i][0]] = fares[i][2];
		} // 초기화
		for (int k = 1; k <= n; k++) { // 플로이드 워셜
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
							&& dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]); // s에서 i까지 합승, i에서 a, b까지 따로
		}
		return answer;
	}

	static public int solution2(int n, int s, int a, int b, int[][] fares) { // 다익스트라 (오류 있음 - 아직 못찾음)
		int answer = Integer.MAX_VALUE;
		int[][] link = new int[n + 1][n + 1];
		for (int i = 0; i < fares.length; i++) { // 도로 연결정보
			link[fares[i][0]][fares[i][1]] = fares[i][2];
			link[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		int[] distS = dijkstra(n, s, link); // s에서 출발해서 다른 지점까지 가는 최단거리
		int[] distA = dijkstra(n, a, link); // a에서 출발해서 다른 지점까지 가는 최단거리
		int[] distB = dijkstra(n, b, link); // b에서 출발해서 다른 지점까지 가는 최단거리

		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, distA[i] + distB[i] + distS[i]); // s에서 i번 지점까지 합승 후 a와 b까지 찢어져 가는 최단 거리
		}
		return answer;
	}

	static public int[] dijkstra(int n, int s, int[][] link) {
		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[s] = 0;
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			int p = queue.poll();
			visit[p] = true;

			for (int i = 1; i <= n; i++) {
				if (!visit[i] && 0 < link[p][i] && result[p] + link[p][i] < result[i]) {
					result[i] = result[p] + link[p][i];
					queue.add(i);
				}
			}
		}

		return result;
	}

}

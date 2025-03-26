package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, vertex));
	}

	static public int solution(int n, int[][] edge) {
		int answer = 0;
		boolean[][] link = new boolean[n + 1][n + 1]; // 노드 연결 정보
		for (int i = 0; i < edge.length; i++) {
			link[edge[i][0]][edge[i][1]] = true;
			link[edge[i][1]][edge[i][0]] = true;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1]; // 방문 확인
		int[] dist = new int[n + 1]; // 1번 노드에서 다른 노드 간 거리
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리 초기화
		queue.add(1);
		dist[1] = 0;

		while (!queue.isEmpty()) { // 다익스트라
			int v = queue.poll();
			visit[v] = true;

			for (int i = 2; i <= n; i++) {
				if (!visit[i] && link[v][i] && dist[v] + 1 < dist[i]) { // 아직 방문x, 연결되어 있으면서 거리가 더 짧으면
					queue.add(i);
					dist[i] = dist[v] + 1;
				}
			}
		}
		int max_dist = 0;
		for (int i = 1; i <= n; i++) {
			if (max_dist < dist[i]) { // 최대 거리 갱신
				max_dist = dist[i];
				answer = 0;
			}

			if (max_dist == dist[i]) { // 최대 거리에 있는 노드이면
				answer += 1;
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 부대복귀 {
	public static void main(String[] args) {
		int n = 3;
		int[][] roads = { { 1, 2 }, { 2, 3 } };
		int[] sources = { 2, 3 };
		int destination = 1;
		System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
	}

	static public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];
		List<List<Integer>> linked = new ArrayList<>(); // 인접한 지역 정보
		for (int i = 0; i <= n; i++) {
			linked.add(new ArrayList<>());
		}
		for (int i = 0; i < roads.length; i++) { // 연결 상태 저장
			linked.get(roads[i][0]).add(roads[i][1]);
			linked.get(roads[i][1]).add(roads[i][0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] dist = new int[n + 1]; // 각 지역까지 최단거리
		boolean[] visit = new boolean[n + 1]; // 방문 확인
		Arrays.fill(dist, Integer.MAX_VALUE);
		queue.add(destination); // 복귀 지역에서 출발
		dist[destination] = 0;

		while (!queue.isEmpty()) { // 다익스트라 알고리즘
			int v = queue.poll();
			visit[v] = true;

			for (int i = 0; i < linked.get(v).size(); i++) {
				int next = linked.get(v).get(i);
				if (!visit[next] && dist[v] + 1 < dist[next]) {
					// 아직 방문한 적 없고, 두 지역이 연결되어 있으면서 최단 거리일 때
					queue.add(next);
					dist[next] = dist[v] + 1;
				}
			}
		}
		for (int i = 0; i < sources.length; i++) { // 복귀해야하는 부대
			if (dist[sources[i]] == Integer.MAX_VALUE) {
				answer[i] = -1;
			} else {
				answer[i] = dist[sources[i]];
			}
		}
		return answer;
	}

	static public int[] solution2(int n, int[][] roads, int[] sources, int destination) { // 메모리 초과
		int[] answer = new int[sources.length];
		boolean[][] link = new boolean[n + 1][n + 1]; // 지역 연결 상태
		for (int i = 0; i < roads.length; i++) { // 연결 상태 저장
			link[roads[i][0]][roads[i][1]] = true;
			link[roads[i][1]][roads[i][0]] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		int[] dist = new int[n + 1]; // 각 지역까지 최단거리
		boolean[] visit = new boolean[n + 1]; // 방문 확인
		Arrays.fill(dist, Integer.MAX_VALUE);
		queue.add(destination); // 복귀 지역에서 출발
		dist[destination] = 0;

		while (!queue.isEmpty()) { // 다익스트라 알고리즘
			int v = queue.poll();
			visit[v] = true;

			for (int i = 1; i <= n; i++) {
				if (!visit[i] && link[v][i] && dist[v] + 1 < dist[i]) {
					// 아직 방문한 적 없고, 두 지역이 연결되어 있으면서 최단 거리일 때
					queue.add(i);
					dist[i] = dist[v] + 1;
				}
			}
		}
		for (int i = 0; i < sources.length; i++) { // 복귀해야하는 부대
			if (dist[sources[i]] == Integer.MAX_VALUE) {
				answer[i] = -1;
			} else {
				answer[i] = dist[sources[i]];
			}
		}
		return answer;
	}

	static public int[] solution3(int n, int[][] roads, int[] sources, int destination) { // 시간 초과, 메모리 초과
		int[] answer = new int[sources.length];
		int[][] dist = new int[n + 1][n + 1]; // i부터 j까지 가는데 걸리는 최단 시간
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < roads.length; i++) {
			dist[roads[i][0]][roads[i][1]] = 1;
			dist[roads[i][1]][roads[i][0]] = 1;
		}
		for (int k = 1; k <= n; k++) { // 플로이드 워셜 알고리즘
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[j][k] != Integer.MAX_VALUE
							&& dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		for (int i = 0; i < sources.length; i++) {
			if (dist[destination][sources[i]] == Integer.MAX_VALUE) { // 도달할 수 없으면 -1
				answer[i] = -1;
			} else {
				answer[i] = dist[destination][sources[i]];
			}
		}
		return answer;
	}
}
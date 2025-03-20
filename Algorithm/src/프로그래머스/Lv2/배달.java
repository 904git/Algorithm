package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 배달 {
	public static void main(String[] args) {
		int N = 5;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		int K = 3;
		System.out.println(solution(N, road, K));
	}

	static public int solution(int N, int[][] road, int K) { // 다익스트라
		int answer = 0;
		int[][] link = new int[N + 1][N + 1]; // i부터 j까지 가는 최소 연결 거리
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) { // 자기 자신이 아니면 가장 큰 값으로 초기화
					link[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < road.length; i++) { // 연결 상태 저장, 두 마을을 연결하는 도로 중 최솟값으로
			link[road[i][0]][road[i][1]] = Math.min(link[road[i][0]][road[i][1]], road[i][2]);
			link[road[i][1]][road[i][0]] = Math.min(link[road[i][1]][road[i][0]], road[i][2]);
		}
		int[] dist = new int[N + 1]; // i번째 노드까지 최단 거리
		Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리 초기화
		boolean[] visit = new boolean[N + 1]; // 방문 확인
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]); // 가중치가 작은 것부터 계산
		queue.add(new int[] { 1, 0 }); // 1번 마을에서 출발
		dist[1] = 0;
		while (!queue.isEmpty()) { // 다익스트라
			int[] v = queue.poll();
			visit[v[0]] = true;

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && link[v[0]][i] != Integer.MAX_VALUE && dist[v[0]] + link[v[0]][i] < dist[i]) {
					dist[i] = dist[v[0]] + link[v[0]][i]; // 최단 거리 갱신
					queue.add(new int[] { i, dist[i] });
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K) { // 거리가 K이하인 노드
				answer += 1;
			}
		}
		return answer;
	}

	static public int solution2(int N, int[][] road, int K) { // 플로이드 워셜
		int answer = 0;
		int[][] link = new int[N + 1][N + 1]; // i부터 j까지 가는 최소 연결 거리
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) { // 자기 자신이 아니면 가장 큰 값으로 초기화
					link[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < road.length; i++) { // 연결 상태 저장, 두 마을을 연결하는 도로 중 최솟값으로
			link[road[i][0]][road[i][1]] = Math.min(link[road[i][0]][road[i][1]], road[i][2]);
			link[road[i][1]][road[i][0]] = Math.min(link[road[i][1]][road[i][0]], road[i][2]);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if ((link[i][k] != Integer.MAX_VALUE && link[k][j] != Integer.MAX_VALUE)
							&& link[i][k] + link[k][j] < link[i][j]) { // i에서 j로 가는데 k를 거쳐가는게 더 빠른지 확인
						link[i][j] = link[i][k] + link[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) { // 1번 마을에서 출발
			System.out.println(link[1][i]);
			if (link[1][i] <= K) { // K시간 이하로 걸리는 마을만 카운트
				answer += 1;
			}
		}
		return answer;
	}
}

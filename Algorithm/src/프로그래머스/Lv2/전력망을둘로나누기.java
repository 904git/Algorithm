package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {
	public static void main(String[] args) {
		int n = 9;
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		System.out.println(solution(n, wires));
	}

	static public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		boolean[][] link = new boolean[n + 1][n + 1]; // 트리 연결 상태
		for (int i = 0; i < wires.length; i++) {
			link[wires[i][0]][wires[i][1]] = true;
			link[wires[i][1]][wires[i][0]] = true;
		}
		for (int i = 0; i < wires.length; i++) { // 전선 하나씩 끊기
			int cnt = cntVertex(n, link, wires[i][0], wires[i][1]);
			answer = Math.min(Math.abs(cnt - (n - cnt)), answer); // 지점 차이가 작은 것
		}
		return answer;
	}

	static public int cntVertex(int n, boolean[][] link, int v1, int v2) { // v1과 연결된 지점 개수 세기
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		queue.add(v1); // 시작점
		visit[v1] = true; // 방문 체크
		int cnt = 0;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			cnt += 1; // 지점 개수 증가
			for (int nv = 1; nv <= n; nv++) {
				if (link[vertex][nv] && !visit[nv] && nv != v2) { // 두 지점이 연결되어 있고 v2가 아니며 아직 방문하지 않은 지점일 때
					queue.add(nv);
					visit[nv] = true;
				}
			}
		}
		return cnt;
	}
}

package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 섬연결하기 {
	static int min_cost;

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		System.out.println(solution(n, costs));
	}

	static public int solution(int n, int[][] costs) {
		int answer = 0;
		Arrays.sort(costs, new MySort()); // cost 오름차순 정렬
		int[] union = new int[n]; // 집합 상태
		for (int i = 0; i < n; i++) {
			union[i] = i;
		}
		for (int i = 0; i < costs.length; i++) {
			if (union(costs[i][0], costs[i][1], union)) { // 두 섬이 연결 가능하면
				answer += costs[i][2];
			}
		}
		return answer;
	}

	static public int findParent(int a, int[] union) { // 집합 부모 찾기
		if (a == union[a]) {
			return a;
		}
		return findParent(union[a], union);
	}

	static public boolean union(int a, int b, int[] union) { // a와 b 합치기
		a = findParent(a, union);
		b = findParent(b, union);

		if (a == b) { // 이미 같은 집합
			return false;
		}

		if (a <= b) { // 번호가 작은 걸 부모로
			union[b] = a;
		} else {
			union[a] = b;
		}
		return true;
	}

	static public int solution2(int n, int[][] costs) { // 시간초과
		int answer = 0;
		Arrays.sort(costs, new MySort());
		boolean[][] link = new boolean[n][n];
		min_cost = Integer.MAX_VALUE;
		go(n, 0, 0, costs, link, 0);
		answer = min_cost;
		return answer;
	}

	static public void go(int n, int cur, int cnt, int[][] costs, boolean[][] link, int cost) {
		if (n - 1 == cnt) {
			if (isLinked(n, link)) {
				min_cost = Math.min(min_cost, cost);
			}
			return;
		} else if (min_cost <= cost) {
			return;
		}

		for (int i = cur; i < costs.length; i++) {
			link[costs[i][0]][costs[i][1]] = true;
			link[costs[i][1]][costs[i][0]] = true;
			go(n, i + 1, cnt + 1, costs, link, cost + costs[i][2]);
			link[costs[i][0]][costs[i][1]] = false;
			link[costs[i][1]][costs[i][0]] = false;
			go(n, i + 1, cnt, costs, link, cost);
		}
	}

	static public boolean isLinked(int n, boolean[][] link) {
		boolean[] visit = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visit[0] = true;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 0; i < n; i++) {
				if (!visit[i] && link[v][i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				return false;
			}
		}
		return true;
	}

	static class MySort implements Comparator<int[]> { // cost 오름차순 정렬
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[2] - o2[2];
		}
	}

}

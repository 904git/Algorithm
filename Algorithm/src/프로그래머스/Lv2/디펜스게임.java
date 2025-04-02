package 프로그래머스.Lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
	public static void main(String[] args) {
		int n = 2, k = 4;
		int[] enemy = { 3, 3, 3, 3 };
		System.out.println(solution(n, k, enemy));
	}

	static public int solution(int n, int k, int[] enemy) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 적 수가 많은 순으로 정렬
		for (int i = 0; i < enemy.length; i++) {
			pq.add(enemy[i]);
			if (enemy[i] <= n) { // 적보다 병사 수가 더 많으면
				n -= enemy[i];
			} else { // 적보다 병사 수가 적으면
				if (k == 0) { // 무적권 없으면 종료
					break;
				} else {
					while (!pq.isEmpty() && 0 < k) {
						n += pq.poll(); // 적 수가 많은 스테이지에 무적권 사용
						k -= 1;
						if (enemy[i] <= n) { // 스테이지 완료
							n -= enemy[i];
							break;
						}
					}
				}
			}
			answer = i + 1;
		}
		return answer;
	}

	static public int solution2(int n, int k, int[] enemy) { // 시간초과
		int answer = 0;
		Queue<Stage> queue = new LinkedList<>();
		queue.add(new Stage(n, k, 0));
		while (!queue.isEmpty()) {
			Stage s = queue.poll();

			if (s.stage < enemy.length && enemy[s.stage] <= s.n) {
				answer = Math.max(answer, s.stage + 1);
				queue.add(new Stage(s.n - enemy[s.stage], s.k, s.stage + 1));
			}
			if (0 < s.k) {
				answer = Math.max(answer, s.stage + 1);
				queue.add(new Stage(s.n, s.k - 1, s.stage + 1));
			}
		}
		return answer;
	}

	static class Stage {
		int n, k;
		int stage;

		Stage(int n, int k, int stage) {
			this.n = n;
			this.k = k;
			this.stage = stage;
		}
	}
}

package 프로그래머스.Lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 혼자놀기의달인 {
	public static void main(String[] args) {
		int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 };
		System.out.println(solution(cards));
	}

	static public int solution(int[] cards) {
		int answer = 0;
		boolean[] visit = new boolean[cards.length]; // 방문 확인
		PriorityQueue<Integer> group = new PriorityQueue<>(Collections.reverseOrder()); // 상자 많은 그룹순
		for (int i = 0; i < cards.length; i++) {
			if (!visit[i]) {
				int cnt = 0;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				visit[i] = true;
				while (!queue.isEmpty()) {
					int n = queue.poll();
					cnt += 1;

					if (!visit[cards[n] - 1]) {
						queue.add(cards[n] - 1);
						visit[cards[n] - 1] = true;
					}
				}
				group.add(cnt);
			}
		}
		if (1 < group.size()) { // 그룹이 1개 이상이면
			answer = group.poll() * group.poll();
		}
		return answer;
	}
}

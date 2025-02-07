package 프로그래머스.Lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println(solution(priorities, location));
	}

	static public int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			q.add(new int[] { i, priorities[i] });
			pq.add(priorities[i]);
		}
		int answer = 0; // 순서
		while (!q.isEmpty()) {
			int[] process = q.poll();
			if (process[1] != pq.peek()) { // 우선순위가 높은 프로세스인지 확인
				// 우선순위가 낮으면 다시 큐에 집어넣기
				q.add(process);
			} else {
				// 프로세스 실행
				pq.poll();
				answer += 1;
				if (process[0] == location) { // 순서가 알고싶었던 프로세스이면 중단
					break;
				}
			}
		}
		return answer;
	}
}

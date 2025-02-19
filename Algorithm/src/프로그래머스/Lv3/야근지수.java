package 프로그래머스.Lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
	public static void main(String[] args) {
		int[] works = { 4, 3, 3 };
		int n = 4;
		System.out.println(solution(n, works));
	}

	static public long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 작업량 내림차순 정렬
		for (int i = 0; i < works.length; i++) {
			pq.add(works[i]);
		}
		while (0 < n && !pq.isEmpty()) {
			// 1시간씩 작업량이 많이 남은 거 작업
			int work = pq.poll();
			if (0 < work) {
				pq.add(work - 1);
				n--;
//				if (work - pq.peek() == 0) {
//					n -= 1;
//					pq.add(work - 1);
//				} else {
//					int temp = Math.min(work - pq.peek(), n);
//					n -= temp;
//					pq.add(work - temp);
//				}
			}
		}
		while (!pq.isEmpty()) { // 피로도 구하기
			int work = pq.poll();
			answer += work * work;
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.PriorityQueue;

public class 더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;
		System.out.println(solution(scoville, k));
	}

	static public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 스코빌지수 오름차순
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		while (pq.peek() < K) { // 현재 가장 낮은 스코빌 지수가 k보다 작을 때
			if (pq.size() < 2) { // 음식 수가 2개 이상이 아니면 만들 수 없음
				answer = -1;
				break;
			}
			int sc = pq.poll() + pq.poll() * 2; // 음식 섞기
			pq.add(sc);
			answer += 1; // 횟수 추가
		}
		return answer;
	}
}

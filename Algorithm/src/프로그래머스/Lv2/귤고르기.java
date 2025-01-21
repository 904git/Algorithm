package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 귤고르기 {
	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };
		System.out.println(solution(k, tangerine));
	}

	static public int solution(int k, int[] tangerine) {
		int answer = 0;
		Arrays.sort(tangerine); // 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 개수 순으로 정렬
		int tangerineNum = tangerine[0], tangerineIdx = 0; // 귤 크기, 인덱스
		for (int i = 0; i < tangerine.length; i++) {
			if (tangerineNum != tangerine[i]) { // 이전 귤과 귤 크기가 다르면, 이전 귤의 개수 저장
				queue.add(i - tangerineIdx);
				tangerineIdx = i;
				tangerineNum = tangerine[i];
			}
		}
		queue.add(tangerine.length - tangerineIdx); // 남은 귤 개수 저장
		while (!queue.isEmpty()) {
			int cnt = queue.poll();
			answer += 1; // 귤 종류 증가
			if (k <= cnt) { // 귤 개수가 충족되었으면 마치기
				break;
			} else {
				k -= cnt; // 필요한 귤 개수 갱신
			}
		}
		return answer;
	}

	static public int solution2(int k, int[] tangerine) {
		int answer = 0;
		int[] cnt = new int[10000001]; // 귤 크기에 따른 개수 카운트
		for (int i = 0; i < tangerine.length; i++) {
			cnt[tangerine[i]] += 1;
		}
		Arrays.sort(cnt); // 개수 순으로 정렬
		for (int i = 0; i < cnt.length; i++) {
			answer += 1; // 귤 종류 증가
			if (k <= cnt[cnt.length - 1 - i]) { // 귤 개수가 충족되었으면 마치기
				break;
			} else {
				k -= cnt[cnt.length - 1 - i]; // 필요한 귤 개수 갱신
			}
		}
		return answer;
	}
}

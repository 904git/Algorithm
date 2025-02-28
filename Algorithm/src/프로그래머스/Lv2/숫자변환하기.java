package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {
	public static void main(String[] args) {
		int x = 10, y = 40, n = 5;
		System.out.println(solution(x, y, n));
	}

	static public int solution(int x, int y, int n) {
		int answer = -1;
		boolean[] visit = new boolean[y + 1]; // 방문 확인
		boolean isPossible = false; // 변환 가능한지 확인
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visit[x] = true;
		while (!queue.isEmpty() && !isPossible) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int num = queue.poll();
				if (num == y) { // y로 변환 가능하면 반복문 종료
					isPossible = true;
					break;
				}

				if (num + n < visit.length && !visit[num + n]) { // x에 n 더하기
					queue.add(num + n);
					visit[num + n] = true;
				}
				if (num * 2 < visit.length && !visit[num * 2]) { // x에 2 곱하기
					queue.add(num * 2);
					visit[num * 2] = true;
				}
				if (num * 3 < visit.length && !visit[num * 3]) { // x에 3 곱하기
					queue.add(num * 3);
					visit[num * 3] = true;
				}
			}
			answer += 1;
		}
		if (!isPossible) { // 변환 불가능 하면 -1
			answer = -1;
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static public int solution(int[] numbers, int target) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (queue.isEmpty()) { // 처음 넣는 수
				queue.add(numbers[i]); // +
				queue.add(-1 * numbers[i]); // -
			} else {
				int size = queue.size();
				for (int s = 0; s < size; s++) { // 이전까지 더해진 수에 +-
					int num = queue.poll();
					queue.add(num + numbers[i]); // +
					queue.add(num - numbers[i]); // -
				}
			}
		}
		while (!queue.isEmpty()) {
			if (queue.poll() == target) { // target이 만들어졌으면 +1
				answer += 1;
			}
		}
		answer = count(target, numbers, 0, 0);
		return answer;
	}

	static public int count(int target, int[] numbers, int idx, int sum) {
		if (idx == numbers.length) { // 배열의 모든 수를 더하거나 뺐을 때
			if (sum == target) return 1; // target이 만들어졌으면
			return 0;
		}
		int cnt = 0;
		cnt += count(target, numbers, idx + 1, sum + numbers[idx]); // +
		cnt += count(target, numbers, idx + 1, sum - numbers[idx]); // -

		return cnt;
	}
}

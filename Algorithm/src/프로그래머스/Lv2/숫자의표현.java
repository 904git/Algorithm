package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자의표현 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>(); // 더해진 수들
		for (int i = 1, sum = 0; i <= n;) {
			if (sum == n) { // 현재까지 수들의 합이 n과 같으면
				answer += 1;
			}

			if (sum <= n) { // 합이 n보다 작으면 더 더하기
				queue.add(i);
				sum += i;
				i++;
			} else { // n < sum , 합이 n보다 크면 앞에 수 빼기
				sum -= queue.poll();
			}
		}
		answer += 1; // 자기 자신만 더한 경우
		return answer;
	}
}

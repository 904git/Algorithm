package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
	public static void main(String[] args) {
		int[] queue1 = { 3, 2, 7, 2 };
		int[] queue2 = { 4, 6, 5, 1 };
		System.out.println(solution(queue1, queue2));
	}

	static public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum_q1 = 0, sum_q2 = 0; // q1안에 있는 원소 합, q2안에 있는 원소 합
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < queue1.length; i++) { // 큐 생성
			q1.add(queue1[i]);
			sum_q1 += queue1[i];
			q2.add(queue2[i]);
			sum_q2 += queue2[i];

		}
		if ((sum_q1 + sum_q2) % 2 != 0) { // 전체 합이 홀수이면 같게 만들 수 없음
			answer = -1;
		} else {
			while (sum_q1 != sum_q2) {
				if (q1.isEmpty() || q2.isEmpty() || 600000 < answer) { // 한쪽이 비어있거나 가능한 최대 횟수를 넘었을 때
					answer = -1;
					break;
				}

				if (sum_q1 < sum_q2) { // q2의 합이 더 클 때
					int num = q2.poll();
					sum_q1 += num;
					sum_q2 -= num;
					q1.add(num);
				} else if (sum_q2 < sum_q1) { // q1의 합이 더 클 때
					int num = q1.poll();
					sum_q2 += num;
					sum_q1 -= num;
					q2.add(num);
				}
				answer += 1;
			}
		}
		return answer;
	}
}

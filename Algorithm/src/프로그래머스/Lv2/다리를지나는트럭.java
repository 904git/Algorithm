package 프로그래머스.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 1;
		int weight = 2;
		int[] truck_wirghts = { 1, 1, 1 };
		System.out.println(solution(bridge_length, weight, truck_wirghts));
	}

	static public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0, bridge_weight = 0, start_time = 1; i < truck_weights.length;) {
			while (!queue.isEmpty() && queue.peek()[1] < start_time) { // 다리를 다 건넌 트럭빼기
				bridge_weight -= queue.poll()[0]; // 무게 감소
			}
			if (bridge_weight + truck_weights[i] <= weight) { // 현재 트럭이 다리를 건널수 있으면
				bridge_weight += truck_weights[i]; // 다리 건너기
				queue.add(new int[] { truck_weights[i], start_time + bridge_length }); // 트럭 무게 : 트럭이 다리를 다 건넜을 때 시간
				start_time += 1; // 출발 시간 갱신
				i += 1; // 다음 트럭
			} else { // 이전 트럭이 다 건너길 기다리기
				int[] truck = queue.poll();
				bridge_weight -= truck[0]; // 무게 감소
				start_time = truck[1]; // 출발 시간 갱신
			}
		}
		while (!queue.isEmpty()) { // 마지막 트럭이 빠져나올때까지 시간 갱신
			answer = queue.poll()[1];
		}
		return answer;
	}
}

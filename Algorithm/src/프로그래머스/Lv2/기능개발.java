package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	static public int[] solution2(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int day = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1; // 100% 완료하는데 걸리는 기간
			if (queue.isEmpty()) {
				queue.add(day);
			} else {
				if (day <= queue.peek()) { // 앞에 작업과 같이 배포
					queue.add(day);
				} else { // 앞에 작업물 다 배포 후에 삽입
					list.add(queue.size());
					queue.clear();
					queue.add(day);
				}
			}
		}
		list.add(queue.size()); // 마지막 작업들 배포
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	static public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int now = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			int day = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1; // 100% 완료하는데 걸리는 기간
			if (day <= now) { // 앞의 작업물과 같이 배포되어야 하면
				stack.add(stack.pop() + 1);
			} else { // 앞의 작업물과 같이 배포 못하면
				stack.add(1);
				now = day;
			}
		}
		answer = new int[stack.size()];
		int i = stack.size() - 1;
		while (!stack.isEmpty()) {
			answer[i--] = stack.pop(); // 뒤에서부터 삽입
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.Stack;

public class 택배상자 {
	public static void main(String[] args) {
		int[] order = { 3, 2, 4, 1, 5 };
		System.out.println(solution(order));
	}

	static public int solution(int[] order) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
		for (int i = 0, num = 1; i < order.length;) {
			if (order[i] != num) { // 컨테이너 벨트에 있는 상자가 현재 순서가 아니면
				if (!stack.isEmpty() && stack.peek() == order[i]) { // 보조 컨테이너 확인
					stack.pop(); // 순서가 맞으면 꺼내 넣기
					answer += 1;
					i += 1;
				} else if (order[i] < num) { // 더 상자를 실을 수 없는 상황
					break;
				} else { // 보조 컨테이너 벨트에 저장
					stack.add(num);
					num += 1;
				}
			} else { // 컨테이너 벨트에서 바로 넣기
				answer += 1;
				num += 1;
				i += 1;
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv1;

import java.util.Stack;

public class 햄버거만들기 {
	public static void main(String[] args) {
		int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
		System.out.println(solution(ingredient));
	}

	static public int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < ingredient.length; i++) {
			if (ingredient[i] != 1) { // 빵 아님
				stack.add(ingredient[i]); // 스택에 그대로 삽입
			} else { // 빵 (가장 마지막에 올라간 빵이라고 판단)
				Stack<Integer> burger = new Stack<>();
				int order = 3;
				while (!stack.isEmpty() && 0 < order) {
					if (stack.peek() != order) { // 넣어야하는 재료 순서가 맞는지 확인
						break;
					}
					burger.add(stack.pop()); // 순서 맞으면 버거 만들기
					order -= 1;
				}

				if (order == 0) { // 버거 완성
					answer += 1;
				} else { // 버거 실패
					while (!burger.isEmpty()) { // 버거 만들려고 뺀 재료 다시 넣기
						stack.add(burger.pop());
					}
					stack.add(ingredient[i]);
				}
			}
		}
		return answer;
	}
}

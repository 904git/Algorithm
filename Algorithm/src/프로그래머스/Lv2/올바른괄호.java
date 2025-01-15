package 프로그래머스.Lv2;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
		String s = "()()";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() && s.charAt(i) == ')') { // 올바르지 않은 괄호
				answer = false;
				break;
			} else if (s.charAt(i) == '(') { // ( 일때 스택에 저장
				stack.add(s.charAt(i));
			} else { // ) 일때 스택에서 제거
				stack.pop();
			}
		}

		if (!stack.isEmpty()) { // 처리되지 않은 괄호가 남아있으면
			answer = false;
		}
		return answer;
	}
}

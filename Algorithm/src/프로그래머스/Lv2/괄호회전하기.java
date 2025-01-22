package 프로그래머스.Lv2;

import java.util.Stack;

public class 괄호회전하기 {
	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			StringBuffer sb = new StringBuffer(s.substring(i) + s.substring(0, i));
			if (isComplete(sb.toString())) { // 회전시킨 괄호 확인
				answer += 1;
			}
		}
		return answer;
	}

	static public boolean isComplete(String s) { // 완전한 괄호이면 true, 아니면 false 반환
		boolean result = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else {
				// 괄호 조건 확인
				if (stack.isEmpty() || (s.charAt(i) == ']' && stack.pop() != '[')
						|| (s.charAt(i) == '}' && stack.pop() != '{') || (s.charAt(i) == ')' && stack.pop() != '(')) {
					result = false;
					break;
				}
			}
		}
		if (!stack.isEmpty()) {
			result = false;
		}
		return result;
	}
}

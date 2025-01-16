package 프로그래머스.Lv2;

import java.util.Stack;

public class 짝지어제거하기 {
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) { // 첫 문자는 그대로 삽입
				stack.add(s.charAt(i));
			} else if (stack.peek() == s.charAt(i)) { // 이전에 넣은 문자와 같은 문자이면 제거 (짝지어 제거하기)
				stack.pop();
			} else { // 이전에 넣은 문자와 다른 문자이면 삽입
				stack.add(s.charAt(i));
			}
		}
		if (stack.isEmpty()) { // 스택이 비어있으면 성공(1), 아니면 실패(0)
			answer = 1;
		}
		return answer;
	}
}

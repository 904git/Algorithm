package 프로그래머스.Lv2;

import java.util.Stack;

public class 괄호변환 {
	public static void main(String[] args) {
		String p = "()))((()";
		System.out.println(solution(p));
	}

	static public String solution(String p) {
		String answer = "";
		answer = replace(p); // 괄호 변환
		return answer;
	}

	static public String replace(String p) {
		if (p.isEmpty()) { // 빈문자열이면 그대로 반환 [1]
			return p;
		}

		int[] cnt = new int[2]; // 여는 괄호, 닫는 괄호 개수
		int idx = 0;
		for (int i = 0; i < p.length(); i++) { // [2]
			if (0 < cnt[0] && cnt[0] == cnt[1]) { // 괄호 개수가 같으면 균형잡힌 문자열 u 찾음
				break;
			}
			if (p.charAt(i) == '(') { // 여는 괄호 개수
				cnt[0] += 1;
			} else { // 닫는 괄호 개수
				cnt[1] += 1;
			}
			idx = i;
		}
		String u = p.substring(0, idx + 1); // 균형잡힌 문자열 u
		String v = p.substring(idx + 1); // 나머지 문자열
		if (isComplete(u)) { // u가 균형잡힌 문자열이면 v에 대해 재귀적으로 수행한 후 리턴 [3]
			return u + replace(v); // [3-1]
		}
		// u가 균형잡힌 문자열이 아니면 [4]
		StringBuffer sb = new StringBuffer();
		sb.append("("); // [4-1]
		sb.append(replace(v)); // [4-2]
		sb.append(")"); // [4-3]
		for (int i = 1; i < u.length() - 1; i++) { // 앞뒤 제거 후 방향 뒤집기 [4-4]
			if (u.charAt(i) == '(') {
				sb.append(")");
			} else {
				sb.append("(");
			}
		}
		return sb.toString();
	}

	static public boolean isComplete(String p) { // 올바른 괄호 문자열인지 확인
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') { // 여는 괄호는 스택에 넣기
				stack.add(p.charAt(i));
			} else { // 닫는 괄호이면
				if (!stack.isEmpty()) { // 짝 확인
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) { // 남은 괄호가 있으면 올바르지 않은 문자열
			return false;
		}
		return true;
	}
}

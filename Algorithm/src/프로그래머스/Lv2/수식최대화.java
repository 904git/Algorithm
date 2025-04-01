package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 수식최대화 {
	static int[] priority; // 연산자 우선순위
	static boolean[] selected;
	static long max; // 최댓값

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}

	static public long solution(String expression) {
		long answer = 0;
		max = Long.MIN_VALUE;
		priority = new int[3]; // 연산자 우선 순위
		selected = new boolean[3];
		perm(0, expression); // 연산자 우선순위 지정
		answer = max;
		return answer;
	}

	static public long solution2(String expression) {
		long answer = 0;
		max = Long.MIN_VALUE;
		priority = new int[3]; // 연산자 우선 순위
		selected = new boolean[3];
		HashMap<String, Integer> op_idx = new HashMap<String, Integer>() { // 연산자 인덱스 [+, - *]
			{
				put("+", 0);
				put("-", 1);
				put("*", 2);
			}
		};
		perm2(0, op_idx, expression); // 연산자 우선순위 지정
		answer = max;
		return answer;
	}

	// 연산자 우선순위 지정
	static public void perm(int cnt, String expression) {
		if (cnt == 3) {
			max = Math.max(max, Math.abs(calculator(expression))); // 최댓값 계산
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!selected[i]) {
				selected[i] = true;
				priority[cnt] = i;
				perm(cnt + 1, expression);
				selected[i] = false;
			}
		}
	}

	// 연산자 우선순위 지정
	static public void perm2(int cnt, HashMap<String, Integer> op_idx, String expression) {
		if (cnt == 3) {
			max = Math.max(max, Math.abs(calculator2(expression, op_idx))); // 최댓값 계산
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!selected[i]) {
				selected[i] = true;
				priority[cnt] = i;
				perm2(cnt + 1, op_idx, expression);
				selected[i] = false;
			}
		}
	}

	static public long calculator(String expression) { // 수식 계산
		List<Long> nums = new ArrayList<>(); // 수식 분리 (숫자)
		List<String> op = new ArrayList<>(); // 수식 분리 (연산자)
		Pattern p = Pattern.compile("[0-9]+|[+*-]"); // 숫자이거나 연산자
		Matcher m = p.matcher(expression);
		while (m.find()) {
			String str = m.group();
			if (str.equals("+") || str.equals("-") || str.equals("*")) {
				op.add(str);
			} else {
				nums.add(Long.parseLong(str));
			}
		}
		
		String[] operation = { "+", "-", "*" };
		for (int i = 0; i < priority.length; i++) { // 우선순위 높은 연산자 순서대로 계산
			for (int j = 0; j < op.size();) {
				if (op.get(j).equals(operation[priority[i]])) { // 현재 연산자가 계산할 연산자이면 계산
					long result = 0; // 숫자 2개 뽑아서 계산
					if (op.get(j).equals("+")) {
						result = nums.remove(j) + nums.remove(j);
					} else if (op.get(j).equals("-")) {
						result = nums.remove(j) - nums.remove(j);
					} else {
						result = nums.remove(j) * nums.remove(j);
					}
					nums.add(j, result); // 계산 결과 다시 삽입
					op.remove(j); // 계산한 연산자 삭제
				} else {
					j += 1;
				}
			}
		}
		return nums.get(0);
	}

	static public long calculator2(String expression, HashMap<String, Integer> op_idx) { // 수식 계산
		List<String> infix = new ArrayList<>(); // 수식 분리 (중위표기법)
		Pattern p = Pattern.compile("[0-9]+|[+*-]"); // 숫자이거나 연산자
		Matcher m = p.matcher(expression);
		while (m.find()) {
			infix.add(m.group());
		}
		List<String> postfix = new ArrayList<>(); // (후위표기법)
		Stack<String> op = new Stack<>();
		for (int i = 0; i < infix.size(); i++) { // 중위표기법을 후위표기법으로 변환
			if (infix.get(i).equals("*") || infix.get(i).equals("+") || infix.get(i).equals("-")) { // 연산자이면
				while (!op.isEmpty() && priority[op_idx.get(infix.get(i))] <= priority[op_idx.get(op.peek())]) {
					// 스택이 비어있지 않을 때, 현재 연산자보다 우선순위가 높은 연산자 모두 출력
					postfix.add(op.pop());
				}
				op.add(infix.get(i)); // 현재 연산자 스택에 추가
			} else { // 숫자이면
				postfix.add(infix.get(i)); // 그대로 출력
			}
		}
		while (!op.isEmpty()) { // 남은 연산자 출력
			postfix.add(op.pop());
		}

		Stack<Long> calc = new Stack<>(); // 후위표기법 수식 계산
		for (int i = 0; i < postfix.size(); i++) {
			// 연산자면 스택에서 숫자 2개 꺼내서 계산
			if (postfix.get(i).equals("*")) { // *
				long b = calc.pop();
				long a = calc.pop();
				calc.add(a * b);
			} else if (postfix.get(i).equals("+")) { // +
				long b = calc.pop();
				long a = calc.pop();
				calc.add(a + b);
			} else if (postfix.get(i).equals("-")) { // -
				long b = calc.pop();
				long a = calc.pop();
				calc.add(a - b);
			} else { // 숫자면 스택에 추가
				calc.add(Long.parseLong(postfix.get(i)));
			}
		}
		return calc.pop();
	}
}

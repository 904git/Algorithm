package 프로그래머스.Lv0;

import java.util.Stack;

public class 문자열계산하기 {
	public static void main(String[] args) {
		String my_string = "3 + 4";
		System.out.println(solution(my_string));
	}

	static public int solution(String my_string) {
		int answer = 0;
		Stack<Integer> numbers = new Stack<>(); // 숫자 저장
		Stack<Character> operation = new Stack<>(); // 연산자 저장
		String[] str_split = my_string.split(" ");
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].equals("+") || str_split[i].equals("-")) { // 연산자이면
				operation.push(str_split[i].charAt(0));
			} else { // 숫자
				if (numbers.isEmpty()) { // 첫 숫자이면
					numbers.push(Integer.parseInt(str_split[i]));
				} else if (operation.size() > 0) { // 이전 결과와 연산
					int num = numbers.pop();
					char op = operation.pop();
					if (op == '+') {
						num += Integer.parseInt(str_split[i]);
					} else {
						num -= Integer.parseInt(str_split[i]);
					}
					numbers.push(num); // 결과값 저장
				}
			}
		}
		answer = numbers.pop();
		return answer;
	}
}

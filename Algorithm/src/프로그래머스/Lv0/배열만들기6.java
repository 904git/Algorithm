package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Stack;

public class 배열만들기6 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 1, 0 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) { // stk이 비어있으면
				stack.push(arr[i]);
			} else if (stack.peek() == arr[i]) { // stk의 마지막 원소와 arr[i]가 같을 때
				stack.pop();
			} else { // stk의 마지막 원소와 arr[i]가 다를 때
				stack.push(arr[i]);
			}
		}
		int size = stack.size();
		int[] answer = { -1 }; // stk가 비어있으면
		if (size > 0) {
			answer = new int[size];
			for (int i = 0; i < size; i++) {
				answer[size - 1 - i] = stack.pop(); // 배열에 뒤에서부터 저장
			}
		}
		return answer;
	}
}

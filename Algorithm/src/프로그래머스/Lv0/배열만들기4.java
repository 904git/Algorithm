package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Stack;

public class 배열만들기4 {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length;) {
			if (stack.isEmpty() || stack.peek() < arr[i]) { // stk가 빈 배열이거나, 마지막 원소가 arr[i]보다 작을 때
				stack.push(arr[i]);
				i++;
			} else { // stk가 비어있지 않고, 마지막 원소가 arr[i]보다 크거나 같을 때
				stack.pop();
			}
		}
		int[] stk = new int[stack.size()];
		for (int i = stk.length - 1; i >= 0; i--) {
			stk[i] = stack.pop();
		}
		return stk;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;
import java.util.Stack;

public class 빈배열에추가삭제하기 {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1, 3 };
		boolean[] flag = { true, false, true, false, false };
		System.out.println(Arrays.toString(solution(arr, flag)));
	}

	static public int[] solution(int[] arr, boolean[] flag) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {// flag가 true면 2배 추가
				for (int j = 0; j < arr[i] * 2; j++) {
					stack.push(arr[i]);
				}
			} else { // flag가 false면 삭제
				for (int j = 0; j < arr[i]; j++) {
					stack.pop();
				}
			}
		}

		int[] answer = new int[stack.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[answer.length - 1 - i] = stack.pop();
		}
		return answer;
	}
}

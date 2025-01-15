package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int pre = -1; // 이전에 나온 수
		for (int i = 0; i < arr.length; i++) {
			if (pre != arr[i]) { // 이전에 나온 수와 현재 수가 다르면 저장
				list.add(arr[i]);
				pre = arr[i];
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

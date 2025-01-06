package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 약수구하기 {
	public static void main(String[] args) {
		int n = 24;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) { // 약수 구하기
				list.add(i);
			}
		}
		// list to array
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

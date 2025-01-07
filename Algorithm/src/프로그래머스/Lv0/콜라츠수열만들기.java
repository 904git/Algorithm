package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 콜라츠수열만들기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		while (n > 0) {
			list.add(n);
			if (n == 1) { // 1이면 반복문 그만
				break;
			}
			if (n % 2 == 0) { // 짝수면 나누기 2
				n /= 2;
			} else { // 홀수면 곱하기 3, 더하기 1
				n = 3 * n + 1;
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

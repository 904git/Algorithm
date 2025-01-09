package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기5 {
	public static void main(String[] args) {
		String[] intStrs = { "0123456789", "9876543210", "9999999999999" };
		int k = 50000;
		int s = 5;
		int l = 5;
		System.out.println(Arrays.toString(solution(intStrs, k, s, l)));
	}

	static public int[] solution(String[] intStrs, int k, int s, int l) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < intStrs.length; i++) {
			int num = Integer.parseInt(intStrs[i].substring(s, s + l)); // 부분 문자열을 정수로 변환
			if (k < num) { // k보다 크면 리스트에 저장
				list.add(num);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

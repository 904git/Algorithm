package 프로그래머스.Lv0;

import java.util.Arrays;

public class 카운트다운 {
	public static void main(String[] args) {
		int start_num = 10, end_num = 3;
		System.out.println(Arrays.toString(solution(start_num, end_num)));
	}

	static public int[] solution(int start_num, int end_num) {
		int[] answer = new int[start_num - end_num + 1];
		for (int i = start_num; i >= end_num; i--) {
			answer[start_num - i] = i;
		}
		return answer;
	}
}

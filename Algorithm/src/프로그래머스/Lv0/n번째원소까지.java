package 프로그래머스.Lv0;

import java.util.Arrays;

public class n번째원소까지 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 1;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	static public int[] solution(int[] num_list, int n) {
		int[] answer = Arrays.copyOf(num_list, n); // 길이 n만큼 copy
		return answer;
	}
}

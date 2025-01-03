package 프로그래머스.Lv0;

import java.util.Arrays;

public class n번째원소부터 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 3;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	static public int[] solution(int[] num_list, int n) {
		int[] answer = Arrays.copyOfRange(num_list, n - 1, num_list.length); // n-1번째부터 끝까지 copy
		return answer;
	}
}

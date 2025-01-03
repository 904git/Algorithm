package 프로그래머스.Lv0;

import java.util.Arrays;

public class 순서바꾸기 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		int n = 1;
		System.out.println(Arrays.toString(solution(num_list, n)));
	}

	static public int[] solution(int[] num_list, int n) {
		int[] answer = new int[num_list.length];
		for (int i = n, idx = 0; i < num_list.length; i++) { // n번째 이후 원소부터 answer에 삽입
			answer[idx++] = num_list[i];
		}
		for (int i = 0; i < n; i++) { // 첫 원소부터 n번째 원소까지 삽입
			answer[num_list.length - n + i] = num_list[i];
		}
		return answer;
	}
}

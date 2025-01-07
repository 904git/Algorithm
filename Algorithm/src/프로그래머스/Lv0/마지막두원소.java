package 프로그래머스.Lv0;

import java.util.Arrays;

public class 마지막두원소 {
	public static void main(String[] args) {
		int[] num_list = { 2, 1, 6 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	static public int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length + 1];
		for (int i = 0; i < num_list.length; i++) {
			answer[i] = num_list[i];
		}
		if (num_list[num_list.length - 1] > num_list[num_list.length - 2]) { // 마지막 원소가 그전 원소보다 크면 빼기
			answer[answer.length - 1] = num_list[num_list.length - 1] - num_list[num_list.length - 2];
		} else { // 마지막 원소가 그전 원소보다 작으면 두배
			answer[answer.length - 1] = num_list[num_list.length - 1] * 2;
		}
		return answer;
	}
}

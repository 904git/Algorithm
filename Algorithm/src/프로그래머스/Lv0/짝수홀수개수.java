package 프로그래머스.Lv0;

import java.util.Arrays;

public class 짝수홀수개수 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	static public int[] solution(int[] num_list) {
		int[] answer = { 0, 0 };
		for (int i = 0; i < num_list.length; i++) {
			answer[num_list[i] % 2] += 1; // 짝수는 인덱스 0을, 홀수는 인덱스 1을 증가
		}
		return answer;
	}

}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열뒤집기 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	static public int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length];
		for (int i = 0; i < num_list.length; i++) {
			answer[i] = num_list[num_list.length - 1 - i]; // 인덱스 반대로 삽입
		}
		return answer;
	}

}

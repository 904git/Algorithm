package 프로그래머스.Lv0;

import java.util.Arrays;

public class 뒤에서5등까지 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 46, 38, 1, 14 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	static public int[] solution(int[] num_list) {
		Arrays.sort(num_list); // 오름차순 정렬
		int[] answer = Arrays.copyOf(num_list, 5); // 길이 5만큼 copy
		return answer;
	}
}

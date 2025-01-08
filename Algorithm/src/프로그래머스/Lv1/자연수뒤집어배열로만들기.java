package 프로그래머스.Lv1;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		int n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(long n) {
		String[] num_split = Long.toString(n).split(""); // 각 자릿수를 문자열로 변환한 배열
		int[] answer = new int[num_split.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(num_split[num_split.length - 1 - i]);
		}
		return answer;
	}
}

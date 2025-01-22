package 프로그래머스.Lv2;

import java.util.Arrays;

public class n2배열자르기 {
	public static void main(String[] args) {
		int n = 3, left = 2, right = 5;
		System.out.println(Arrays.toString(solution(n, left, right)));
	}

	static public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
		int idx = 0;
		for (long i = left; i < right + 1; i++) { // i는 이차원 배열에서 (i/n행, i%n열)
			answer[idx++] = (int) Math.max(i / n, i % n) + 1;
		}
		return answer;
	}
}

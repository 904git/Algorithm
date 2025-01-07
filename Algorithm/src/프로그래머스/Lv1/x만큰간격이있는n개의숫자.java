package 프로그래머스.Lv1;

import java.util.Arrays;

public class x만큰간격이있는n개의숫자 {
	public static void main(String[] args) {
		int x = 2, n = 5;
		System.out.println(Arrays.toString(solution(x, n)));
	}

	static public long[] solution(int x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = x + (long) x * i; // 값이 int 값을 넘어갈 수도 있으니 형 변환해주기
		}
		return answer;
	}
}

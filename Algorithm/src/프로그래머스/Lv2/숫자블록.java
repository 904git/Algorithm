package 프로그래머스.Lv2;

import java.util.Arrays;

public class 숫자블록 {
	public static void main(String[] args) {
		int begin = 477559014, end = 477559014;
		System.out.println(Arrays.toString(solution(begin, end)));
	}

	static public int[] solution(long begin, long end) {
		int[] answer = new int[(int) (end - begin) + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (int) getMaxDivisor(begin + i);
		}
		return answer;
	}

	static public int getMaxDivisor(long n) { // 자기 자신을 제외한 가장 큰 약수
		if (n == 1) {
			return 0;
		}
		int result = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i <= 10000000) { // 천만까지만 블록 설치
					return (int) n / i;
				}
				result = i;
			}
		}
		return result;
	}

}

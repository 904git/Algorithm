package 프로그래머스.Lv0;

import java.util.Arrays;

public class 분수의덧셈 {
	public static void main(String[] args) {
		int numer1 = 1, denom1 = 2, numer2 = 3, denom2 = 4;
		System.out.println(Arrays.toString(solution(numer1, denom1, numer2, denom2)));
	}

	static public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];
		answer[0] = numer1 * denom2 + numer2 * denom1; // 분자 덧셈
		answer[1] = denom1 * denom2; // 분모 덧셈
		int gcd = GCD(answer[0], answer[1]); // 최대공약수
		for (int i = 0; i < answer.length; i++) {
			answer[i] /= gcd; // 분자, 분모를 최대공약수로 나누기
		}
		return answer;
	}

	static public int GCD(int a, int b) { // 두 수의 최대공약수
		int result = 0;
		for (int i = Math.min(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				result = i;
				break;
			}
		}
		return result;
	}
}

package 프로그래머스.Lv1;

import java.util.Arrays;

public class 최대공약수와최소공배수 {
	public static void main(String[] args) {
		int n = 3, m = 12;
		System.out.println(Arrays.toString(solution(n, m)));
	}

	static public int[] solution(int n, int m) {
		int[] answer = { 0, 1 };
		for (int i = 1; i <= n && i <= m; i++) { // 최대공약수
			if (n % i == 0 && m % i == 0) {
				answer[0] = i;
			}
		}

		for (int i = 2; i <= n || i <= m;) { // 최소공배수
			if (n % i == 0 || m % i == 0) {
				answer[1] *= i;
				n = n % i == 0 ? n / i : n;
				m = m % i == 0 ? m / i : m;
			} else {
				i++;
			}
		}
		return answer;
	}
}

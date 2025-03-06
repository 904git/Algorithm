package 프로그래머스.Lv2;

public class _2xn타일링 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		int[] F = new int[n + 1]; // 피보나치 수열
		F[0] = 1;
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = (F[i - 1] + F[i - 2]) % 1000000007;
		}
		answer = F[n];
		return answer;
	}
}

package 프로그래머스.Lv2;

public class 멀리뛰기 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static public long solution(int n) {
		long answer = 0;
		long[] f = new long[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = (f[i - 1] + f[i - 2]) % 1234567;
		}
		answer = f[n];
		return answer;
	}
}

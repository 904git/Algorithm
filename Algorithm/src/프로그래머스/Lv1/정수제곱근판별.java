package 프로그래머스.Lv1;

public class 정수제곱근판별 {
	public static void main(String[] args) {
		int n = 121;
		System.out.println(solution(n));
	}

	static public long solution(long n) {
		long answer = 0;
		if (n % Math.sqrt(n) == 0) {
			answer = (long) Math.pow((Math.sqrt(n) + 1), 2);
		} else {
			answer = -1;
		}
		return answer;
	}
}

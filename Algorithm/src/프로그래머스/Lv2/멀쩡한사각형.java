package 프로그래머스.Lv2;

public class 멀쩡한사각형 {
	public static void main(String[] args) {
		int w = 8, h = 12;
		System.out.println(solution(w, h));
	}

	static public long solution(int w, int h) {
		long answer = 1;
		int gcd = getGCD(w, h);
		answer = (long) w * h - (w + h - gcd);
		return answer;
	}

	static public int getGCD(int a, int b) {
		for (int i = Math.min(a, b); i > 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}
}

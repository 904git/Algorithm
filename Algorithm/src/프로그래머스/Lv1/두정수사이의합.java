package 프로그래머스.Lv1;

public class 두정수사이의합 {
	public static void main(String[] args) {
		int a = 3, b = 5;
		System.out.println(solution(a, b));
	}

	static public long solution(int a, int b) {
		long answer = 0;
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
			answer += i;
		}
		return answer;
	}
}

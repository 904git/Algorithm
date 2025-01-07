package 프로그래머스.Lv0;

public class 홀짝에따라다른값반환하기 {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		if (n % 2 != 0) { // 홀수이면
			for (int i = 1; i <= n; i += 2) {
				answer += i;
			}
		} else { // 짝수이면
			for (int i = 2; i <= n; i += 2) {
				answer += i * i;
			}
		}
		return answer;
	}
}

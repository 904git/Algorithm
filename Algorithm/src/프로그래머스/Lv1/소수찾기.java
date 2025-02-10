package 프로그래머스.Lv1;

public class 소수찾기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i++) { // 1은 소수가 아니므로 제외
			if (isPrime(i)) { // 소수이면 +1
				answer += 1;
			}
		}
		return answer;
	}

	static public boolean isPrime(int n) { // n이 소수인지 아닌지 확인
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) { // 1과 자기자신 외에 나누어 떨어지는 수가 존재하면 소수가 아님
				return false;
			}
		}
		return true;
	}
}

package 프로그래머스.Lv1;

public class 약수의합 {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				answer += i;
				answer += n / i;
			}
		}
		if (n % Math.sqrt(n) == 0) { // 제곱수인 경우 한번만 더해줌
			answer += Math.sqrt(n);
		}
		return answer;
	}
}

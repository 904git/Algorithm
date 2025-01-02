package 프로그래머스.Lv0;

public class 짝수의합 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i += 2) { // 1부터 n까지 짝수
			answer += i;
		}
		return answer;
	}
}

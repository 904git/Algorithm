package 프로그래머스.Lv0;

public class 자릿수더하기 {
	public static void main(String[] args) {
		int n = 1234;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10; // 끝자리부터 더하기
			n = n / 10;
		}
		return answer;
	}
}

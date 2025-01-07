package 프로그래머스.Lv1;

public class 자릿수더하기 {
	public static void main(String[] args) {
		int N = 123;
		System.out.println(solution(N));
	}

	static public int solution(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	}
}

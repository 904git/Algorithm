package 프로그래머스.Lv0;

public class 공배수 {
	public static void main(String[] args) {
		int number = 60, n = 2, m = 3;
		System.out.println(solution(number, n, m));
	}

	static public int solution(int number, int n, int m) {
		int answer = 0;
		if (number % n == 0 && number % m == 0) { // n과 m으로 나누어 떨어져야함
			answer = 1;
		}
		return answer;
	}

}

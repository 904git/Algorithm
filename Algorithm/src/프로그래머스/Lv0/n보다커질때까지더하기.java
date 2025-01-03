package 프로그래머스.Lv0;

public class n보다커질때까지더하기 {
	public static void main(String[] args) {
		int[] numbers = { 34, 5, 71, 29, 100, 34 };
		int n = 123;
		System.out.println(solution(numbers, n));
	}

	static public int solution(int[] numbers, int n) {
		int answer = 0, i = 0;
		do {
			answer += numbers[i];
			i++;
		} while (i < numbers.length && answer <= n); // answer가 n보다 작으면 계속 더함
		return answer;
	}

}

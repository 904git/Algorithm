package 프로그래머스.Lv0;

public class 저주의숫자3 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			answer += 1;
			while (answer % 3 == 0 || Integer.toString(answer).contains("3")) { // 현재 수가 3의 배수이거나 숫자 3을 사요하지 않을때까지 +1
				answer += 1;
			}
		}
		return answer;
	}
}

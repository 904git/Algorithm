package 프로그래머스.Lv0;

public class 주사위게임1 {
	public static void main(String[] args) {
		int a = 3, b = 5;
		System.out.println(solution(a, b));
	}

	static public int solution(int a, int b) {
		int answer = 0;
		if ((a * b) % 2 != 0) { // a와 b 모두 홀수
			answer = (a * a) + (b * b);
		} else if ((a + b) % 2 != 0) { // a와 b 중 하나만 홀수
			answer = 2 * (a + b);
		} else { // a와 b 모두 짝수
			answer = Math.abs(a - b);
		}
		return answer;
	}
}

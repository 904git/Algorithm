package 프로그래머스.Lv0;

public class 주사위게임2 {
	public static void main(String[] args) {
		int a = 2, b = 6, c = 1;
		System.out.println(solution(a, b, c));
	}

	static public int solution(int a, int b, int c) {
		int answer = 0;
		answer = a + b + c; // 모두 다르면
		if (a == b || b == c || c == a) { // 두 숫자가 같으면
			answer *= (a * a + b * b + c * c);
		}
		if (a == b && b == c && c == a) { // 세 숫자가 같으면
			answer *= (a * a * a + b * b * b + c * c * c);
		}
		return answer;
	}
}

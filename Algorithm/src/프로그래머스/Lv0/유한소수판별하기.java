package 프로그래머스.Lv0;

public class 유한소수판별하기 {
	public static void main(String[] args) {
		int a = 3, b = 90;
		System.out.println(solution(a, b));
	}

	static public int solution(int a, int b) {
		int answer = 1;
		for (int i = 2; i <= b;) {
			if (b % i == 0) { // i는 b의 소인수
				if (a % i == 0) { // a의 소인수이면
					a /= i;
				} else if (i != 2 && i != 5) { // a의 소인수가 아니면서 i가 2나 5가 아니면 무한소수
					answer = 2;
					break;
				}
				b /= i;
			} else {
				i += 1;
			}
		}
		return answer;
	}
}

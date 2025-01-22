package 프로그래머스.Lv2;

public class 예상대진표 {
	public static void main(String[] args) {
		int n = 8, a = 4, b = 7;
		System.out.println(solution(n, a, b));
	}

	static public int solution(int n, int a, int b) {
		int answer = 1;
		// 같이 붙는 번호끼리 몫 마추기 위해 -1
		a = a - 1;
		b = b - 1;
		while (a / 2 != b / 2) { // 같은 라운드인지 확인
			answer += 1;
			a /= 2;
			b /= 2;
		}
		return answer;
	}
}

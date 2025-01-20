package 프로그래머스.Lv1;

public class 콜라문제 {
	public static void main(String[] args) {
		int a = 2, b = 1;
		int n = 20;
		System.out.println(solution(a, b, n));
	}

	static public int solution(int a, int b, int n) {
		int answer = 0;
		int cola = n;
		while (a <= cola) {
			answer += (cola / a) * b; // 서비스로 받은 콜라
			cola = (cola / a) * b + cola % a; // 빈병 수
		}
		return answer;
	}
}

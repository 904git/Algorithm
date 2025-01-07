package 프로그래머스.Lv0;

public class n의배수 {
	public static void main(String[] args) {
		int num = 98, n = 2;
		System.out.println(solution(num, n));
	}

	static public int solution(int num, int n) {
		int answer = num % n == 0 ? 1 : 0;
		return answer;
	}
}

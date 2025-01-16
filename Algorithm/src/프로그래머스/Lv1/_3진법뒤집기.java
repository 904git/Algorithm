package 프로그래머스.Lv1;

public class _3진법뒤집기 {
	public static void main(String[] args) {
		int n = 45;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		while (n >= 1) { // 3진법 변환
			sb.insert(0, n % 3);
			n /= 3;
		}
		sb.reverse();
		for (int i = sb.toString().length() - 1, mul = 1; i >= 0; i--) { // 10진법 변환
			answer += Character.getNumericValue(sb.toString().charAt(i)) * mul;
			mul *= 3;
		}
		return answer;
	}
}

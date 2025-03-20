package 프로그래머스.Lv2;

public class _124나라의숫자 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		while (0 < n) {
			if ((n - 1) % 3 == 2) {
				sb.insert(0, 4);
			} else {
				sb.insert(0, (n - 1) % 3 + 1);
			}
			n = (n - 1) / 3;
		}
		answer = sb.toString();
		return answer;
	}
}

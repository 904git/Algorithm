package 프로그래머스.Lv0;

public class 조건문자열 {
	public static void main(String[] args) {
		String ineq = "<", eq = "=";
		int n = 20, m = 50;
		System.out.println(solution(ineq, eq, n, m));

	}

	static public int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if (ineq.equals("<")) {
			if (eq.equals("=")) {
				answer = n <= m ? 1 : 0;
			} else {
				answer = n < m ? 1 : 0;
			}
		} else {
			if (eq.equals("=")) {
				answer = n >= m ? 1 : 0;
			} else {
				answer = n > m ? 1 : 0;
			}
		}
		return answer;
	}
}

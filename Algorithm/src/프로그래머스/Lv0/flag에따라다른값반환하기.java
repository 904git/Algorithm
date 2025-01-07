package 프로그래머스.Lv0;

public class flag에따라다른값반환하기 {
	public static void main(String[] args) {
		int a = -4, b = 7;
		boolean flag = true;
		System.out.println(solution(a, b, flag));
	}

	static public int solution(int a, int b, boolean flag) {
		int answer = 0;
		if (flag) { // flag가 true면
			answer = a + b;
		} else { // flag가 false면
			answer = a - b;
		}
		return answer;
	}
}

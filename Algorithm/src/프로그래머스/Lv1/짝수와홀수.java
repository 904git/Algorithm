package 프로그래머스.Lv1;

public class 짝수와홀수 {
	public static void main(String[] args) {
		int num = 3;
		System.out.println(solution(num));
	}

	static public String solution(int num) {
		String answer = "";
		if (num % 2 != 0) {
			answer = "Odd";
		} else {
			answer = "Even";
		}
		return answer;
	}
}

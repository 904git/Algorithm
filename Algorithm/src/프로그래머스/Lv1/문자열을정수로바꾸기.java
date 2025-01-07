package 프로그래머스.Lv1;

public class 문자열을정수로바꾸기 {
	public static void main(String[] args) {
		String s = "-1234";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = Integer.parseInt(s);
		return answer;
	}
}

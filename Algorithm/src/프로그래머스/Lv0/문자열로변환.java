package 프로그래머스.Lv0;

public class 문자열로변환 {
	public static void main(String[] args) {
		int n = 123;
		System.out.println(solution(n));
	}

	static public String solution(int n) {
		String answer = Integer.toString(n);
		return answer;
	}
}

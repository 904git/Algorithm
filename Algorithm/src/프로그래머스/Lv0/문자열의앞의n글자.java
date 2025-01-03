package 프로그래머스.Lv0;

public class 문자열의앞의n글자 {
	public static void main(String[] args) {
		String my_string = "ProgrammerS123";
		int n = 11;
		System.out.println(solution(my_string, n));
	}

	static public String solution(String my_string, int n) {
		String answer = my_string.substring(0, n); // 0번째부터 n-1번째까지 문자열
		return answer;
	}
}

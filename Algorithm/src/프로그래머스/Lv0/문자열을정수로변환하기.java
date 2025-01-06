package 프로그래머스.Lv0;

public class 문자열을정수로변환하기 {
	public static void main(String[] args) {
		String n_str = "10";
		System.out.println(solution(n_str));
	}

	static public int solution(String n_str) {
		int answer = Integer.parseInt(n_str);
		return answer;
	}
}

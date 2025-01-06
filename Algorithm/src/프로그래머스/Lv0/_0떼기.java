package 프로그래머스.Lv0;

public class _0떼기 {
	public static void main(String[] args) {
		String n_str = "0010";
		System.out.println(solution(n_str));
	}

	static public String solution(String n_str) {
		String answer = Integer.toString(Integer.parseInt(n_str));
		return answer;
	}
}

package 프로그래머스.Lv0;

public class 세균증식 {
	public static void main(String[] args) {
		int n = 2, t = 10;
		System.out.println(solution(n, t));
	}

	static public int solution(int n, int t) {
		int answer = n * (int) Math.pow(2, t); // t번 2배 해주기(2의 t승)
		return answer;
	}

}

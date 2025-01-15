package 프로그래머스.Lv0;

public class 종이자르기 {
	public static void main(String[] args) {
		int m = 3, n = 5;
		System.out.println(solution(m, n));
	}

	static public int solution(int M, int N) {
		int answer = 0;
		answer = (M - 1) + M * (N - 1);
		return answer;
	}
}

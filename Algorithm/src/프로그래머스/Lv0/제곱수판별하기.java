package 프로그래머스.Lv0;

public class 제곱수판별하기 {
	public static void main(String[] args) {
		int n = 144;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		if (Math.sqrt(n) % 1 == 0) { // 루트 n이 정수이면 제곱수
			answer = 1;
		} else {
			answer = 2;
		}
		return answer;
	}

}

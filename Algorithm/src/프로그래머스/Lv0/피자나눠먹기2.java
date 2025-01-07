package 프로그래머스.Lv0;

public class 피자나눠먹기2 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = n;
		if (n % 2 != 0) { // n의 인수에 2가 없으면 곱해주기
			answer *= 2;
		}
		if (n % 3 != 0) { // n의 인수에 3이 없으면 곱해주기
			answer *= 3;
		} // answer는 n과 6의 최소공배수
		answer /= 6; // 피자 수
		return answer;
	}
}

package 프로그래머스.Lv1;

public class 나머지가1이되는수찾기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 1) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}

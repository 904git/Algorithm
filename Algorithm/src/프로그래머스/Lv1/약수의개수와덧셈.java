package 프로그래머스.Lv1;

public class 약수의개수와덧셈 {
	public static void main(String[] args) {
		int left = 13, right = 17;
		System.out.println(solution(left, right));
	}

	static public int solution(int left, int right) {
		int answer = 0;
		for (int n = left; n <= right; n++) {
			int cnt = 0;
			// 약수 개수 구하기
			for (int i = 1; i < Math.sqrt(n); i++) {
				if (n % i == 0) {
					cnt += 2;
				}
			}
			if (n % Math.sqrt(n) == 0) {
				cnt += 1;
			}

			if (cnt % 2 == 0) { // 약수의 개수가 짝수이면 더하기
				answer += n;
			} else { // 약수의 개수가 홀수이면 빼기
				answer -= n;
			}
		}
		return answer;
	}
}

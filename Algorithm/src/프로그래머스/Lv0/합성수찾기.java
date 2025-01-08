package 프로그래머스.Lv0;

public class 합성수찾기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) { // 1에서 n까지 수 탐색
			int cnt = 0;
			// i의 약수의 개수 찾기
			for (int j = 1; j < Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt += 2;
				}
			}
			if (i % Math.sqrt(i) == 0) {
				cnt += 1;
			}
			// 약수의 개수가 3개 이상이면 합성수
			if (3 <= cnt) {
				answer += 1;
			}
		}
		return answer;
	}
}

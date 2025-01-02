package 프로그래머스.Lv0;

public class 순서쌍의개수 {
	public static void main(String[] args) {
		int n = 20;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i < Math.sqrt(n); i++) { // 1부터 루트n까지 나눠지는 쌍 찾기
			if (n % i == 0) {
				answer++;
			}
		}
		answer *= 2; // 순서가 바뀐 것도 세어야 하므로 (ex. [1,20], [20,1])
		if (Math.sqrt(n) % 1 == 0) { // n이 제곱수이면 +1
			answer += 1;
		}
		return answer;
	}

}

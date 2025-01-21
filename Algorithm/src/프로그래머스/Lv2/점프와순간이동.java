package 프로그래머스.Lv2;

public class 점프와순간이동 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		if (n == 1) { // 남은 거리가 1이면 건전기 사용량 1
			return 1;
		}

		if (n % 2 == 0) { // 남은 거리가 짝수면 순간이동으로 건전지 사용량 0
			return solution(n / 2);
		} else { // 남은 거리가 홀수면 한 칸은 점프, 나머지는 순간이동
			return 1 + solution((n - 1) / 2);
		}
	}
}

package 프로그래머스.Lv2;

public class 시소짝꿍 {
	public static void main(String[] args) {
		int[] weights = { 100, 180, 360, 100, 270 };
		System.out.println(solution(weights));
	}

	static public long solution(int[] weights) {
		long answer = 0;
		int[] weights_cnt = new int[1001]; // 무게별 사람 수
		for (int i = 0; i < weights.length; i++) {
			weights_cnt[weights[i]] += 1;
		}
		for (int i = 100; i < weights_cnt.length; i++) {
			if (0 < weights_cnt[i]) {
				answer += ((long) weights_cnt[i] * (weights_cnt[i] - 1)) / 2; // 1:1
				if (i % 2 == 0) {
					answer += (long) weights_cnt[i] * weights_cnt[i / 2]; // 2:1
				}
				if (i % 3 == 0) {
					answer += (long) weights_cnt[i] * weights_cnt[i / 3 * 2]; // 3:2
				}
				if (i % 4 == 0) {
					answer += (long) weights_cnt[i] * weights_cnt[i / 4 * 3]; // 4:3
				}
			}
		}
		return answer;
	}

	static public long solution2(int[] weights) {
		long answer = 0;
		for (int i = 0; i < weights.length - 1; i++) {
			for (int j = i + 1; j < weights.length; j++) {
				int gcd = gcd(weights[i], weights[j]); // 최대공약수
				double dist = (double) Math.max(weights[i] / gcd, weights[j] / gcd)
						/ Math.min(weights[i] / gcd, weights[j] / gcd); // 배율
				if (dist == 1 || dist == 1.5 || dist == 2 || dist == (double) 4 / 3) { // 시소에 평행하게 앉을 수 배율이면
					answer += 1; // 시소 짝꿍
				}
			}
		}
		return answer;
	}

	static public int gcd(int a, int b) { // 두 수의 최대공약수 구하기
		for (int i = Math.min(a, b); 1 < i; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}
}

package 프로그래머스.Lv2;

public class k진수에서소수개수구하기 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));
	}

	static public int solution(int n, int k) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		while (0 < n) { // k진법으로 변환
			sb.insert(0, n % k);
			n /= k;
		}
		String[] str_split = sb.toString().split("0"); // 0을 포함하지 않는 수들
		for (int i = 0; i < str_split.length; i++) {
			if (0 < str_split[i].length() && isPrime(Long.parseLong(str_split[i]))) { // 소수이면 +1
				answer += 1;
			}
		}
		return answer;
	}

	static public boolean isPrime(Long n) { // n이 소수인지 확인하는 함수
		if (n == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

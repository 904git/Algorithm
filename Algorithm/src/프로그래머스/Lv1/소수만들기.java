package 프로그래머스.Lv1;

public class 소수만들기 {
	static int primeCnt;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(solution(nums));
	}

	static public int solution(int[] nums) {
		int answer = -1;
		primeCnt = 0;
		comb(nums, 0, 0, 0); // 3개의 수를 더하는 조합
		answer = primeCnt;
		return answer;
	}

	static public void comb(int[] nums, int cur, int cnt, int sum) { // nums에서 3개의 수를 뽑아서 더하는 조합
		if (cnt == 3) {
			if (isPrime(sum)) { // 3개의 수를 합했을 때 이 수가 소수인지 확인
				primeCnt += 1;
			}
			return;
		}

		for (int i = cur; i < nums.length; i++) {
			comb(nums, i + 1, cnt + 1, sum + nums[i]);
		}
	}

	static public boolean isPrime(int n) { // n이 소수인지 아닌지 확인
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

package 프로그래머스.Lv3;

public class 거스름돈 {
	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		System.out.println(solution(n, money));
	}

	static public int solution(int n, int[] money) {
		int answer = 0;
		int[] cnt = new int[n + 1]; // cnt[n] : 숫자 n을 만드는 방법의 수
		cnt[0] = 1;
		for (int i = 0; i < money.length; i++) {
			for (int j = money[i]; j <= n; j++) {
				cnt[j] = (cnt[j] + cnt[j - money[i]]) % 1000000007;
			}
		}
		answer = cnt[n];
		return answer;
	}
}

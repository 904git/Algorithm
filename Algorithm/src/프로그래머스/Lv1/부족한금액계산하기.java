package 프로그래머스.Lv1;

public class 부족한금액계산하기 {
	public static void main(String[] args) {
		int price = 3, money = 20, count = 4;
		System.out.println(solution(price, money, count));
	}

	static public long solution(int price, int money, int count) {
		long answer = -1;
		long sum = 0; // 총 발생한 금액
		for (int i = 1; i <= count; i++) {
			sum += price * i;
		}
		answer = Math.max(0, sum - money); // (sum-money)가 음수이면 돈이 부족하지 않은 것
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.Arrays;

public class 주식가격 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(prices)));
	}

	static public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = prices.length - 2; 0 <= i; i--) {
			int time = 0;
			for (int j = i + 1; j < prices.length; j++) {
				time += 1;
				if (prices[j] < prices[i]) { // 가격 떨어짐
					break;
				}
			}
			answer[i] = time;
		}
		return answer;
	}
}

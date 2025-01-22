package 프로그래머스.Lv2;

import java.util.HashMap;

public class 할인행사 {
	public static void main(String[] args) {
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
		System.out.println(solution(want, number, discount));
	}

	static public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		for (int i = 0; i < discount.length; i++) {
			boolean check = true; // 구매 가능한지 확인용
			HashMap<String, Integer> shopping = new HashMap<>(); // i번째날부터 10일동안 살 수 있는 물품 수
			for (int j = i; j < Math.min(i + 10, discount.length); j++) {
				if (shopping.containsKey(discount[j])) {
					shopping.replace(discount[j], shopping.get(discount[j]) + 1);
				} else {
					shopping.put(discount[j], 1);
				}
			}
			for (int j = 0; j < want.length; j++) {
				if (!shopping.containsKey(want[j]) || shopping.get(want[j]) < number[j]) { // 살 수 있는 물품에 원하는 물건이 없거나
																							// 개수가 부족하면 false
					check = false;
					break;
				}
			}
			if (check) {
				answer += 1;
			}
		}
		return answer;
	}
}

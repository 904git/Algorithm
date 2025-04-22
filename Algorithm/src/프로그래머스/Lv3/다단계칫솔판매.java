package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계칫솔판매 {
	public static void main(String[] args) {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}

	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length]; // 판매원별 이익
		HashMap<String, Integer> seller_idx = new HashMap<>(); // 판매원 인덱스
		HashMap<String, String> parent = new HashMap<>(); // 판매원의 상사
		for (int i = 0; i < enroll.length; i++) {
			parent.put(enroll[i], referral[i]);
			seller_idx.put(enroll[i], i);
		}
		for (int i = 0; i < seller.length; i++) {
			int money = amount[i] * 100; // 판매원 이익
			String s = seller[i]; // 현재 판매원
			while (!s.equals("-") && 0 < money) { // 현재 판매원이 센터이거나 전해지는 이익이 0 이하이면 중단
				int parent_profit = money / 10; // 상사에게 줄 이익
				answer[seller_idx.get(s)] += money - parent_profit; // 본인이 갖는 이익
				money = parent_profit;
				s = parent.get(s);
			}
		}
		return answer;
	}

}

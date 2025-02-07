package 프로그래머스.Lv2;

import java.util.Arrays;

public class 전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	static public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book); // 사전순으로 정렬
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) { // 전화번호 비교
				answer = false;
				break;
			}
		}
		return answer;
	}
}

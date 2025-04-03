package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 개인정보수집유효기간 {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = { "A 6", "B 12", "C 3" };
		String[] privacied = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
		System.out.println(Arrays.toString(solution(today, terms, privacied)));
	}

	static public int[] solution(String today, String[] terms, String[] privacies) {
		int[] answer = {};
		HashMap<String, Integer> term = new HashMap<>(); // 약관 별 보관 기간
		for (int i = 0; i < terms.length; i++) {
			String[] str_split = terms[i].split(" ");
			term.put(str_split[0], Integer.parseInt(str_split[1]));
		}
		List<Integer> expriation = new ArrayList<>(); // 폐기할 약관 번호
		int today_date = getIntDate(today); // 오늘 날짜값
		for (int i = 0; i < privacies.length; i++) {
			String[] str_split = privacies[i].split(" ");
			int expiration_date = getExpirationDate(getIntDate(str_split[0]), term.get(str_split[1])); // 만료 날짜
			if (expiration_date <= today_date) { // 만료 날짜가 지났으면
				expriation.add(i + 1); // 폐기
			}
		}
		answer = new int[expriation.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = expriation.get(i);
		}
		return answer;
	}

	static public int getIntDate(String date) { // 문자열 날짜를 숫자로
		String[] str_split = date.split("[.]");
		return Integer.parseInt(str_split[0]) * 12 * 28 + Integer.parseInt(str_split[1]) * 28
				+ Integer.parseInt(str_split[2]);
	}

	static public int getExpirationDate(int date, int term) { // 만료 날짜 계산
		return date + term * 28;
	}
}

package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] order = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(solution(order, course)));
	}

	static public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		List<String> courses = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			HashMap<String, Integer> menu = new HashMap<>(); // 단품메뉴 course[i]개 조합
			for (int j = 0; j < orders.length; j++) {
				if (course[i] <= orders[j].length()) {
					char[] order = orders[j].toCharArray(); // 알파벳순 정렬
					Arrays.sort(order);
					comb(course[i], 0, 0, order, "", menu); // 조합
				}
			}
			int max = 0; // 최대 주문 횟수
			List<String> selected = new ArrayList<>(); // 가장 많이 주문한 코스 선택
			for (String foods : menu.keySet()) {
				if (1 < menu.get(foods) && max <= menu.get(foods)) { // 1번이상 주문하고 최대 횟수일 때
					if (max < menu.get(foods)) { // 최대 횟수 갱신
						selected.clear(); // 이전 코스 초기화
						max = menu.get(foods);
					}
					selected.add(foods); // 코스 추가
				}
			}
			courses.addAll(selected); // 정답 추가
		}
		Collections.sort(courses); // 사전 순 정렬
		answer = courses.toArray(new String[courses.size()]); // List -> Array
		return answer;
	}

	static public void comb(int r, int cur, int cnt, char[] order, String foods, HashMap<String, Integer> menu) { // 조합
		if (r == cnt) {
			menu.put(foods, menu.getOrDefault(foods, 0) + 1);
			return;
		}

		for (int i = cur; i < order.length; i++) {
			StringBuffer sb = new StringBuffer(foods + order[i]);
			comb(r, i + 1, cnt + 1, order, sb.toString(), menu);
		}
	}
}

package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 의상 {
	static String[] selected;
	static int count;

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" }, { "green", "addd" } };
		System.out.println(solution(clothes));

		// 1 2
		// 3
		// 4
		// 1, 2, 3, 4, 13, 14, 23, 24, 34, 134, 234
	}

	static public int solution(String[][] clothes) {
		HashMap<String, Integer> typeCnt = new HashMap<>(); // 종류별 개수
		for (int i = 0; i < clothes.length; i++) {
			if (typeCnt.containsKey(clothes[i][1])) {
				typeCnt.replace(clothes[i][1], typeCnt.get(clothes[i][1]) + 1);
			} else {
				typeCnt.put(clothes[i][1], 1);
			}
		}
		int answer = 1;
		for (String type : typeCnt.keySet()) {
			answer *= typeCnt.get(type) + 1; // 종류별로 (입을 수 있는 경우의 수 + 1(안 입는 경우)) 곱해주기
		}
		answer -= 1; // 모두 다 안 입는 경우 빼주기 (-1)
		return answer;
	}

	static public int solution2(String[][] clothes) {
		int answer = 0;
		HashSet<String> hash = new HashSet<>();
		for (int i = 0; i < clothes.length; i++) {
			hash.add(clothes[i][1]);
		}
		for (int i = 1; i <= hash.size(); i++) {
			HashSet<String> type = new HashSet<>(); // 옷 종류
			select2(clothes, type, i, 0, 0);
		}
		answer = count;
		return answer;
	}

	static public void select2(String[][] clothes, HashSet<String> hash, int r, int cur, int cnt) { // 입을 옷 고르기
		if (cnt == r) {
			count++;
			return;
		}

		for (int i = cur; i < clothes.length; i++) {
			if (!hash.contains(clothes[i][1])) {
				hash.add(clothes[i][1]);
				select2(clothes, hash, r, i + 1, cnt + 1);
				hash.remove(clothes[i][1]);
			}

		}
	}

	static public int solution3(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> typeCnt = new HashMap<>(); // 종류별 개수
		List<String> types = new ArrayList<>(); // 옷 종류
		for (int i = 0; i < clothes.length; i++) {
			if (typeCnt.containsKey(clothes[i][1])) {
				typeCnt.replace(clothes[i][1], typeCnt.get(clothes[i][1]) + 1);
			} else {
				typeCnt.put(clothes[i][1], 1);
				types.add(clothes[i][1]);
			}
		}
		count = 0;
		for (int i = 1; i <= types.size(); i++) { // 옷 입는 개수별 경우의 수
			selected = new String[i];
			select3(typeCnt, types, i, 0, 0);
		}
		answer = count;
		return answer;
	}

	static public void select3(HashMap<String, Integer> hash, List<String> list, int r, int cur, int cnt) { // 입을 옷 고르기
		if (cnt == r) {
			int result = 1;
			for (int i = 0; i < selected.length; i++) {
				result *= hash.get(selected[i]);
			}
			count += result;
			return;
		}

		for (int i = cur; i < list.size(); i++) {
			selected[cnt] = list.get(i);
			select3(hash, list, r, i + 1, cnt + 1);
		}
	}
}

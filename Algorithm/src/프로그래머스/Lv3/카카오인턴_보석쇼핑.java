package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 카카오인턴_보석쇼핑 {
	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(Arrays.toString(solution(gems)));
	}

	static public int[] solution(String[] gems) {
		int[] answer = { 0, 0 };
		HashMap<String, Integer> gems_cnt = new HashMap<>(); // left에서 right까지 구간에 가지고 있는 보석
		int size = new HashSet<>(Arrays.asList(gems)).size(); // 보석 종류
		int left = 0, len = gems.length + 1;
		for (int right = 0; right < gems.length; right++) {
			gems_cnt.put(gems[right], gems_cnt.getOrDefault(gems[right], 0) + 1);

			while (1 < gems_cnt.get(gems[left])) { // 구간 좁히기 (중복해서 가지고 있는 것 없애기)
				gems_cnt.put(gems[left], gems_cnt.get(gems[left]) - 1);
				left += 1;
			}

			if (gems_cnt.size() == size && right - left < len) { // 보석 종류가 다 모이고, 구간 길이가 최소일 떄
				len = right - left;
				answer[0] = left + 1;
				answer[1] = right + 1;
			}
		}
		return answer;
	}

	static public int[] solution2(String[] gems) {
		int[] answer = { 0, 0 };
		HashMap<String, Integer> gems_cnt = new HashMap<>(); // 보석 개수
		int size = new HashSet<>(Arrays.asList(gems)).size(); // 보석 종류
		int left = 0, right = 0;
		int len = gems.length + 1;
		gems_cnt.put(gems[right], 1);
		while (true) {
			if (gems_cnt.size() == size) { // 보석 종류가 다 모였으면
				if (right - left < len) { // 최소 길이 구간
					len = right - left;
					answer[0] = left + 1;
					answer[1] = right + 1;
				}
				if (gems_cnt.get(gems[left]) <= 1) { // 보석 수 갱신
					gems_cnt.remove(gems[left]);
				} else {
					gems_cnt.replace(gems[left], gems_cnt.get(gems[left]) - 1);
				}
				left += 1; // left 이동
				if (gems.length <= left) { // 범위 확인
					break;
				}
			} else {
				right += 1; // right 이동
				if (gems.length <= right) { // 범위 확인
					break;
				}
				if (!gems_cnt.containsKey(gems[right])) { // 보석수 갱신
					gems_cnt.put(gems[right], 1);
				} else {
					gems_cnt.replace(gems[right], gems_cnt.get(gems[right]) + 1);
				}
			}
		}
		return answer;
	}

	static public int[] solution3(String[] gems) {
		int[] answer = { 0, 0 };
		HashMap<String, Integer> gem_idx = new HashMap<>(); // 보석 인덱스
		int start = 0, end = 0;
		for (int i = 0; i < gems.length; i++) {
			if (!gem_idx.containsKey(gems[i])) { // 새 종류의 보석이 나오면
				gem_idx.put(gems[i], i);
				end = i;
				answer[0] = start + 1;
				answer[1] = end + 1;
			} else { // 이미 있던 보석이면
				gem_idx.replace(gems[i], i); // 인덱스 갱신
				if (gems[start].equals(gems[i])) {
					int min = Integer.MAX_VALUE;
					for (String gem : gem_idx.keySet()) {
						min = Math.min(gem_idx.get(gem), min);
					}
					if (end - min < answer[1] - answer[0]) {
						start = min;
						end = i;
						answer[0] = start + 1;
						answer[1] = end + 1;
					}
				}
			}
		}
		return answer;
	}

	static public int[] solution4(String[] gems) { // 시간초과
		int[] answer = { 1, 1 };
		HashMap<String, Integer> gems_num = new HashMap<>();
		HashMap<Integer, Integer> gems_idx = new HashMap<>();
		for (int i = 0; i < gems.length; i++) {
			if (!gems_num.containsKey(gems[i])) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < gems_num.size(); j++) {
					min = Math.min(min, gems_idx.get(j));
				}
				gems_num.put(gems[i], gems_num.size());
				gems_idx.put(gems_num.get(gems[i]), i + 1);
				if (min != Integer.MAX_VALUE) {
					answer[0] = min;
				}
				answer[1] = i + 1;
			} else {
				int min = Integer.MAX_VALUE;
				int num = gems_num.get(gems[i]);
				for (int j = 0; j < gems_num.size(); j++) {
					if (j != num) {
						min = Math.min(min, gems_idx.get(j));
					}
				}
				if (min != Integer.MAX_VALUE && (i + 1) - min < answer[1] - answer[0]) {
					answer[0] = min;
					answer[1] = i + 1;
				}
				gems_idx.replace(num, i + 1);
			}
		}
		return answer;
	}
}

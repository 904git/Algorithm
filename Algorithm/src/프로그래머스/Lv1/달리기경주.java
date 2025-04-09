package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 달리기경주 {
	public static void main(String[] args) {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };
		System.out.println(Arrays.toString(solution(players, callings)));
	}

	static public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];
		HashMap<String, Integer> player_idx = new HashMap<>(); // 선수들 위치
		for (int i = 0; i < players.length; i++) {
			answer[i] = players[i];
			player_idx.put(players[i], i);
		}
		for (int i = 0; i < callings.length; i++) {
			int idx = player_idx.get(callings[i]); // 이름 불린 선수의 위치
			// 선수 추월
			answer[idx] = answer[idx - 1];
			answer[idx - 1] = callings[i];
			player_idx.put(answer[idx], idx);
			player_idx.put(callings[i], idx - 1);
		}
		return answer;
	}

	static public String[] solution2(String[] players, String[] callings) { // 시간 초과
		String[] answer = new String[players.length];
		List<String> race = new ArrayList<>(); // 경주 상황
		for (int i = 0; i < players.length; i++) {
			race.add(players[i]);
		}
		for (int i = 0; i < callings.length; i++) {
			int idx = race.indexOf(callings[i]); // 불린 선수 위치
			race.remove(callings[i]);
			race.add(idx - 1, callings[i]); // 한칸 앞으로 이동
		}
		for (int i = 0; i < players.length; i++) {
			answer[i] = race.get(i);
		}
		return answer;
	}
}

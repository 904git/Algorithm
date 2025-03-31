package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 여행경로 {
	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
//		String[][] tickets = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "ICN", "AXA" }, { "ANU", "ICN" },
//				{ "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, { "ADL", "EZE" },
//				{ "EZE", "ADL" }, { "AXA", "EZE" }, { "AUA", "AXA" }, { "ICN", "AXA" }, { "AXA", "AUA" },
//				{ "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" }, { "AUA", "ANU" } };
		System.out.println(Arrays.toString(solution(tickets)));
	}

	static public String[] solution(String[][] tickets) {
		String[] answer = {};
		List<String> airports = new ArrayList<>(); // 공항 리스트
		for (int i = 0; i < tickets.length; i++) {
			for (int j = 0; j < tickets[i].length; j++) {
				if (!airports.contains(tickets[i][j])) {
					airports.add(tickets[i][j]);
				}
			}
		}
		Collections.sort(airports); // 사전순 정렬
		int[][] flight = new int[airports.size()][airports.size()]; // 항공편
		for (int i = 0; i < tickets.length; i++) {
			flight[airports.indexOf(tickets[i][0])][airports.indexOf(tickets[i][1])] += 1; // 티켓 수
		}
		List<Integer> route = new ArrayList<>(); // 이동 경로
		int icn = airports.indexOf("ICN"); // 시작 공항 (인천)
		route.add(icn);
		go(tickets.length, 0, icn, flight, route); // DFS
		answer = new String[route.size()];
		for (int i = 0; i < route.size(); i++) {
			answer[i] = airports.get(route.get(i));
		}
		return answer;
	}

	static public boolean go(int ticket_cnt, int cnt, int airport_idx, int[][] flight, List<Integer> result) { // DFS
		if (ticket_cnt == cnt) { // 사용한 티켓 수가 가지고 있는 티켓 수와 같으면 성공
			return true;
		}
		boolean flag = false;
		for (int i = 0; i < flight.length; i++) {
			if (0 < flight[airport_idx][i]) { // 현재 경로로 갈 수 있으면
				flight[airport_idx][i] -= 1; // 티켓 소모
				result.add(i); // 경로 추가
				flag = go(ticket_cnt, cnt + 1, i, flight, result); // 다음 경로 탐색
				if (flag) { // 경로 찾기 성공하면 반복문 종료
					break;
				} else { // 실패하면 티켓 되돌리기
					flight[airport_idx][i] += 1;
					result.remove(result.size() - 1);
				}
			}
		}
		return flag;
	}

}

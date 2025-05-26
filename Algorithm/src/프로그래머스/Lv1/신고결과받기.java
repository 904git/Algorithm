package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.HashMap;

public class 신고결과받기 {
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	static public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> id_idx = new HashMap<>(); // 유저 아이디 인덱스
		int[][] warning_cnt = new int[id_list.length][id_list.length]; // 신고 횟수 [신고 한 유저][신고 당한 유저]
		for (int i = 0; i < id_list.length; i++) {
			id_idx.put(id_list[i], i);
		}
		for (int i = 0; i < report.length; i++) {
			String[] str_split = report[i].split(" ");
			if (warning_cnt[id_idx.get(str_split[0])][id_idx.get(str_split[1])] == 0) { // 동일한 유저에 대한 신고 횟수 1회
				warning_cnt[id_idx.get(str_split[0])][id_idx.get(str_split[1])] += 1;
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			int sum = 0; // 유저 신고 횟수
			for (int j = 0; j < id_list.length; j++) {
				sum += warning_cnt[j][i];
			}
			if (k <= sum) { // 신고 횟수가 기준을 넘으면 메일 보내기
				for (int j = 0; j < id_list.length; j++) {
					if (0 < warning_cnt[j][i]) { // 해당 유저를 신고한 기록이 있으면 메일 전송 횟수 추가
						answer[j] += 1;
					}
				}
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv1;

import java.util.HashMap;

public class 성격유형검사하기 {
	public static void main(String[] args) {
		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
		int[] choicees = { 5, 3, 2, 7, 5 };
		System.out.println(solution(survey, choicees));
	}

	static public String solution(String[] survey, int[] choices) {
		String answer = "";
		Character[] types = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' }; // 성격유형
		HashMap<Character, Integer> type_idx = new HashMap<>(); // 유형 인덱스
		for (int i = 0; i < types.length; i++) {
			type_idx.put(types[i], i);
		}
		int[] scores = new int[types.length];
		for (int i = 0; i < survey.length; i++) {
			// 점수를 얻는 유형 = (choices[i] / 4), 얻는 점수 |choices[i] - 4|
			char type = survey[i].charAt(choices[i] / 4);
			int score = Math.abs(choices[i] - 4);
			scores[type_idx.get(type)] += score;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < types.length; i += 2) {
			if (scores[i] < scores[i + 1]) { // 점수가 더 큰 유형으로
				sb.append(types[i + 1]);
			} else {
				sb.append(types[i]);
			}
		}
		answer = sb.toString();
		return answer;
	}
}

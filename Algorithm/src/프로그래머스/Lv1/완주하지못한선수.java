package 프로그래머스.Lv1;

import java.util.HashMap;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(solution(participant, completion));
	}

	static public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < participant.length; i++) { // 선수 등록
			if (!hashMap.containsKey(participant[i])) {
				hashMap.put(participant[i], 1);
			} else {
				hashMap.replace(participant[i], hashMap.get(participant[i]) + 1);
			}
		}
		for (int i = 0; i < completion.length; i++) {
			hashMap.replace(completion[i], hashMap.get(completion[i]) - 1); // 완주한 사람 제거
		}
		for (String p : hashMap.keySet()) {
			if (0 < hashMap.get(p)) { // 완주하지 못한 사람
				answer = p;
				break;
			}
		}
		return answer;
	}
}

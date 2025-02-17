package 프로그래머스.Lv2;

import java.util.HashMap;

public class 모음사전 {
	static int cnt;
	static char[] gather = { 'A', 'E', 'I', 'O', 'U' };

	public static void main(String[] args) {
		String word = "AAAAE";
		System.out.println(solution(word));
	}

	static public int solution(String word) {
		int answer = 0;
		HashMap<String, Integer> dict = new HashMap<>(); // 사전
		StringBuffer sb = new StringBuffer();
//		initDict(sb, dict); // 사전 정의
//		answer = dict.get(word);
		findWord(sb, word);
		answer = cnt;
		return answer;
	}

	static public void initDict(StringBuffer sb, HashMap<String, Integer> dict) { // 사전 정의
		if (sb.length() > 5) { // 길이 5까지만 정의
			return;
		}
		dict.put(sb.toString(), cnt);
		cnt += 1;

		for (int i = 0; i < gather.length; i++) {
			sb.append(gather[i]);
			initDict(sb, dict);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	static public boolean findWord(StringBuffer sb, String word) {
		if (sb.length() > 5) { // 길이 5까지만 탐색
			return false;
		} else if (sb.toString().equals(word)) { // 단어를 찾으면
			return true;
		}
		cnt += 1; // 단어 순 카운트
		boolean find = false;
		for (int i = 0; i < gather.length && !find; i++) {
			sb.append(gather[i]);
			find = findWord(sb, word);
			sb.deleteCharAt(sb.length() - 1);
		}
		return find;
	}
}

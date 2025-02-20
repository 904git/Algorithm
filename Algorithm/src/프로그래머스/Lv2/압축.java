package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 압축 {
	public static void main(String[] args) {
		String msg = "KAKAO";
		System.out.println(Arrays.toString(solution(msg)));
	}

	static public int[] solution(String msg) {
		int[] answer = {};
		HashMap<String, Integer> dict = new HashMap<>(); // 사전
		for (int i = 0; i < 26; i++) { // 사전 초기화 (알파벳 대문자)
			dict.put(Character.toString((char) ('A' + i)), i + 1);
		}
		List<Integer> list = new ArrayList<>(); // 압축
		for (int i = 0; i < msg.length();) { // 단어 시작 위치
			int j = i + 1;
			while (j <= msg.length()) { // 사전에 등록 안된 단어의 끝 인덱스 찾기
				if (!dict.containsKey(msg.substring(i, j))) { // 등독 안되어 있는 단어이면
					dict.put(msg.substring(i, j), dict.size() + 1); // 사전에 추가
					break; // 반복문 종료
				}
				j += 1;
			}
			list.add(dict.get(msg.substring(i, j - 1))); // 사전에 이미 있었던 단어로 압축
			i = j - 1; // 다음 압축할 단어 인덱스로 이동
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

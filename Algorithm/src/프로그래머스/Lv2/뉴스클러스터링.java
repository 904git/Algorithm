package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "FRANCE", str2 = "french";
		System.out.println(solution(str1, str2));
	}

	static public int solution(String str1, String str2) {
		int answer = 0;
		List<String> str1_split = new ArrayList<>(); // str1을 두 글자씩 끊은 다중집합
		List<String> str2_split = new ArrayList<>(); // str2을 두 글자씩 끊은 다중집합
		for (int i = 0; i < str1.length() - 1; i++) {
			if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) { // 특수 문자 없으면
				str1_split.add(str1.substring(i, i + 2).toUpperCase()); // 모두 대문자로 변경
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) { // 특수 문자 없으면
				str2_split.add(str2.substring(i, i + 2).toUpperCase()); // 모두 대문자로 변경
			}
		}
		int union = str1_split.size() + str2_split.size(), intersection = 0;
		for (int i = 0; i < str2_split.size(); i++) {
			int idx = str1_split.indexOf(str2_split.get(i));
			if (0 <= idx) { // 교집합 수
				intersection += 1;
				str1_split.remove(idx);
			}
		}
		union -= intersection; // 합집합 수 (집합1 + 집합2 - 교집합)
		if (union == 0 && intersection == 0) {
			answer = 1 * 65536;
		} else {
			answer = (int) ((double) intersection / union * 65536);
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
	public static void main(String[] args) {
		int n = 3;
		String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	static public int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };
		HashSet<String> word = new HashSet<>(); // 단어 중복 체크
		for (int i = 0; i < words.length; i++) {
			if (word.isEmpty()) {
				word.add(words[i]);
			} else if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) { // 현재 단어 첫 글자와 직전 단어와
																								// 마지막 글자가 다르면
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			} else if (word.contains(words[i])) { // 중복된 단어를 말하면
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			} else {
				word.add(words[i]);
			}
		}
		return answer;
	}
}

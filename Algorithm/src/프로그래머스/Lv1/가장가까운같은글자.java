package 프로그래머스.Lv1;

import java.util.Arrays;

public class 가장가까운같은글자 {
	public static void main(String[] args) {
		String s = "banana";
		System.out.println(Arrays.toString(solution(s)));
	}

	static public int[] solution(String s) {
		int[] answer = new int[s.length()];
		int[] alphaIdx = new int[26];
		Arrays.fill(alphaIdx, -1);
		for (int i = 0; i < s.length(); i++) {
			if (alphaIdx[s.charAt(i) - 'a'] < 0) { // 처음 나온 알파벳이면
				answer[i] = -1;
			} else {
				answer[i] = i - alphaIdx[s.charAt(i) - 'a'];
			}
			alphaIdx[s.charAt(i) - 'a'] = i;
		}
		return answer;
	}
}

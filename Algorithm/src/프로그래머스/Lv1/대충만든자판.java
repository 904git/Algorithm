package 프로그래머스.Lv1;

import java.util.Arrays;

public class 대충만든자판 {
	public static void main(String[] args) {
		String[] keymap = { "ABACD", "BCEFD" };
		String[] targets = { "ABCD", "AABB" };
		System.out.println(Arrays.toString(solution(keymap, targets)));
	}

	static public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		int[] key = new int[26]; // 문자를 입력하는데 눌러야 하는 최소 횟수
		Arrays.fill(key, Integer.MAX_VALUE);
		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				key[keymap[i].charAt(j) - 'A'] = Math.min(key[keymap[i].charAt(j) - 'A'], j + 1); // 최소 횟수 갱신
			}
		}
		for (int i = 0; i < targets.length; i++) {
			for (int j = 0; j < targets[i].length(); j++) {
				if (key[targets[i].charAt(j) - 'A'] == Integer.MAX_VALUE) { // 등록이 안 된 문자이면 입력 실패 (-1)
					answer[i] = -1;
					break;
				}
				answer[i] += key[targets[i].charAt(j) - 'A']; // 눌러야하는 횟수 더하기
			}
		}
		return answer;
	}
}
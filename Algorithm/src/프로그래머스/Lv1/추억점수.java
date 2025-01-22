package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
	public static void main(String[] args) {
		String[] name = { "may", "kein", "kain", "radi" };
		int[] yearning = { 5, 10, 1, 3 };
		String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
				{ "kon", "kain", "may", "coni" } };
		System.out.println(Arrays.toString(solution(name, yearning, photo)));
	}

	static public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		HashMap<String, Integer> people = new HashMap<>(); // 이름 : 추억점수
		for (int i = 0; i < name.length; i++) {
			people.put(name[i], yearning[i]);
		}
		for (int i = 0; i < photo.length; i++) {
			int score = 0;
			for (int j = 0; j < photo[i].length; j++) {
				if (people.containsKey(photo[i][j])) { // 이름에 맞는 점수가 있으면
					score += people.get(photo[i][j]);
				}
			}
			answer[i] = score;
		}
		return answer;
	}
}

package 프로그래머스.Lv0;

import java.util.Arrays;

public class _5명씩 {
	public static void main(String[] args) {
		String[] names = { "nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx" };
		System.out.println(Arrays.toString(solution(names)));
	}

	static public String[] solution(String[] names) {
		String[] answer = new String[names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1];
		// 5명을 꽉 채우지 못할 경우 + 1
		for (int i = 0; i < answer.length; i++) {
			answer[i] = names[5 * i];
		}
		return answer;
	}
}

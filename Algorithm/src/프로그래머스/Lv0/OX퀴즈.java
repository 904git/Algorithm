package 프로그래머스.Lv0;

import java.util.Arrays;

public class OX퀴즈 {
	public static void main(String[] args) {
		String[] quiz = { "3 - 4 = -3", "5 + 6 = 11" };
		System.out.println(Arrays.toString(solution(quiz)));
	}

	static public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		for (int q = 0, result = 0; q < quiz.length; q++) {
			String[] str_split = quiz[q].split(" ");
			if (str_split[1].equals("+")) { // 연산자가 +이면
				result = Integer.parseInt(str_split[0]) + Integer.parseInt(str_split[2]);
			} else { // 연산자가 -이면
				result = Integer.parseInt(str_split[0]) - Integer.parseInt(str_split[2]);
			}

			if (result == Integer.parseInt(str_split[4])) { // 결과값이 맞는지 확인
				answer[q] = "O";
			} else {
				answer[q] = "X";
			}
		}
		return answer;
	}
}

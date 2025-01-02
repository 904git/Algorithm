package 프로그래머스.Lv0;

import java.util.Arrays;

public class 아이스아메리카노 {
	public static void main(String[] args) {
		int money = 5500;
		System.out.println(Arrays.toString(solution(money)));
	}

	static public int[] solution(int money) {
		int[] answer = new int[2];
		answer[0] = money / 5500; // 현재 돈으로 살 수 있는 커피 수
		answer[1] = money - 5500 * answer[0]; // 커피를 사고 남은 돈
		return answer;
	}

}

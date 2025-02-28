package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.HashSet;

public class 로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}

	static public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		HashSet<Integer> lottoNum = new HashSet<>(); // 로또 추첨 번호
		for (int i = 0; i < win_nums.length; i++) {
			lottoNum.add(win_nums[i]);
		}
		int zeroCnt = 0, matchCnt = 0;
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] != 0) { // 지워진 숫자가 아니고
				if (lottoNum.contains(lottos[i])) { // 추첨 번호와 맞으면
					matchCnt += 1;
				}
			} else { // 지워진 번호
				zeroCnt += 1;
			}
		}
		answer[0] = lottoClass(matchCnt + zeroCnt); // 최고 순위는 지워진 번호가 모두 추첨 번호와 일치할 때
		answer[1] = lottoClass(matchCnt); // 최저 순위는 지워진 번호가 모두 추천 번호와 일치하지 않을 때
		return answer;
	}

	static public int lottoClass(int score) { // 로또 순위 반환
		if (1 <= score) {
			return 7 - score;
		}
		return 6;
	}
}

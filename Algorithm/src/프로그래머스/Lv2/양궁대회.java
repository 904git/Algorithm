package 프로그래머스.Lv2;

import java.util.Arrays;

public class 양궁대회 {
	static int[] result;
	static int max;

	public static void main(String[] args) {
		int n = 5;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(solution(n, info)));
	}

	static public int[] solution(int n, int[] info) {
		int[] answer = new int[n];
		int max = 0;
		int[] ryan = new int[info.length];
		result = new int[info.length];
		go(n, 0, 0, 0, max, ryan, info);
		answer = result;
		return answer;
	}

	static public void go(int cnt, int cur, int score, int apeach, int max, int[] ryan, int[] info) {
		if (cnt == 0) {
			if (apeach < score && max < score - apeach) { // 라이언이 이김
				max = score - apeach;
				for (int i = 0; i < ryan.length; i++) {
					result[i] = ryan[i];
				}
			}
			return;
		}

		for (int i = cur; i < info.length; i++) {
			if (info[i] < cnt) {
				ryan[i] = info[i] + 1;
				go(cnt - (info[i] + 1), i + 1, score + (10 - i), apeach, max, ryan, info);
			}
			ryan[i] = 0;
			go(cnt, i + 1, score, apeach + (10 - i), max, ryan, info);
		}
	}

	static class Stage {
		int cnt, ryan, apeach;

		Stage(int cnt, int ryan, int apeach) {
			this.cnt = cnt;
			this.ryan = ryan;
			this.apeach = apeach;
		}
	}
}

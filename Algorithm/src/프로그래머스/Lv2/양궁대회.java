package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 양궁대회 {
	public static void main(String[] args) {
		int n = 5;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(solution(n, info)));
	}

	static public int[] solution(int n, int[] info) {
		int[] answer = new int[info.length];
		Queue<Game> queue = new LinkedList<>();
		queue.add(new Game(n, 0, new int[info.length]));
		int max = -1;
		while (!queue.isEmpty()) {
			Game g = queue.poll();
			if (g.cnt == 0 || g.cur == info.length) { // 더이상 게임 진행을 못 함
				if (0 < g.cnt) {
					g.ryan[g.ryan.length - 1] = g.cnt;
				}
				int score = getScoreDiff(g.ryan, info);
				if (max <= score) {
					max = score;
					answer = g.ryan;
				}
				continue;
			}

			if (info[g.cur] < g.cnt) { // 라이언이 이길 수 있음
				int value = info[g.cur] + 1;
				int[] nRyan = getNextRyan(g.cur, value, g.ryan);
				queue.add(new Game(g.cnt - value, g.cur + 1, nRyan));
			}
			int[] nRyan = getNextRyan(g.cur, 0, g.ryan);
			queue.add(new Game(g.cnt, g.cur + 1, nRyan)); // 이기지 못하므로 화살 아끼기

		}
		if (max < 0) {
			answer = new int[] { -1 };
		}
		return answer;
	}

	static public int[] getNextRyan(int cur, int value, int[] ryan) {
		int[] nRyan = new int[ryan.length];
		for (int i = 0; i < cur; i++) {
			nRyan[i] = ryan[i];
		}
		nRyan[cur] = value;
		return nRyan;
	}

	static public int getScoreDiff(int[] ryan, int[] apeach) {
		int[] score = new int[2];
		for (int i = 0; i < ryan.length; i++) {
			if (apeach[i] < ryan[i]) {
				score[0] += (10 - i);
			} else if (apeach[i] != 0 && ryan[i] <= apeach[i]) {
				score[1] += (10 - i);
			}
		}
		if (score[1] < score[0]) {
			return score[0] - score[1];
		}
		return -1;
	}

	static class Game {
		int[] ryan;
		int cnt, cur;

		Game(int cnt, int cur, int[] ryan) {
			this.cnt = cnt;
			this.cur = cur;
			this.ryan = ryan;
		}
	}
}

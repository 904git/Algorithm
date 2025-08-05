package 프로그래머스.Lv2;

import java.util.Arrays;

public class N_Queen {
	static int count;
	static int[] dj = { -1, 0, 1 };

	public static void main(String[] args) {
		int n = 12;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		count = 0;
		int[][] map = new int[n][n];
		int[][][] dir = new int[n][n][dj.length];
		go(n, 0, map, dir);
		answer = count;
		return answer;
	}

	static void go(int n, int cnt, int[][] map, int[][][] dir) {
		if (cnt == n) {
			count += 1;
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int d = 0; d < dj.length; d++) {
				int nj = i + dj[d];

				if (0 <= cnt - 1 && 0 <= nj && nj < n && (map[cnt - 1][nj] == 1 || dir[cnt - 1][nj][d] == 1)) {
					dir[cnt][i][d] = 1;
					map[cnt][i] = 2;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (map[cnt][i] == 0) {
				map[cnt][i] = 1;
				go(n, cnt + 1, map, dir);
				map[cnt][i] = 0;
			}
		}
		dir[cnt] = new int[n][dj.length];
		map[cnt] = new int[n];
	}

	static void printArray(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================");
	}
}

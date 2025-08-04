package 프로그래머스.Lv2;

public class N_Queen {
	static int count;
	static int[] dj = { -1, 0, 1 };

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		count = 0;
		int[][] map = new int[n][n];
		go(n, 0, map);
		answer = count;
		return answer;
	}

	static void go(int n, int cnt, int[][] map) {
		if (cnt == n) {
			count += 1;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (map[cnt][i] == 0) {
				map[cnt][i] = 2;
				fillArray(1, cnt, i, map);
				go(n, cnt + 1, map);
				map[cnt][i] = 0;
				fillArray(0, cnt, i, map);
			} else {
				fillArray(1, cnt, i, map);
			}
		}
	}

	static void fillArray(int value, int i, int j, int[][] map) {
		for (int d = 0; d < dj.length; d++) {
			int ni = i + 1;
			int nj = j + dj[d];

			if (0 <= ni && ni < map.length && 0 <= nj && nj < map.length) {
				map[ni][nj] = value;
			}
		}
	}

	static void printArray(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

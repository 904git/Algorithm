package 프로그래머스.Lv2;

public class N_Queen {
	static int count;
	static int[] dj = { -1, 0, 1 };

	public static void main(String[] args) {
		int n = 12;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		int answer = 0;
		boolean[] col = new boolean[n]; // 세로줄 확인
		boolean[] rightDiag = new boolean[2 * n - 1]; // 오른쪽대각선 확인
		boolean[] leftDiag = new boolean[2 * n - 1]; // 왼쪽대각선 확인
		answer = nQueen(n, 0, col, rightDiag, leftDiag);
		return answer;
	}

	static int nQueen(int n, int row, boolean[] colUsed, boolean[] rightDiag, boolean[] leftDiag) {
		if (row == n) {
			return 1;
		}
		int result = 0;
		for (int col = 0; col < n; col++) {
			// 세로, 오른쪽 대각선, 왼쪽 대각선 확인
			if (!colUsed[col] && !rightDiag[row + col] && !leftDiag[row - 1 + n - col]) {
				colUsed[col] = rightDiag[row + col] = leftDiag[row - 1 + n - col] = true;
				result += nQueen(n, row + 1, colUsed, rightDiag, leftDiag);
				colUsed[col] = rightDiag[row + col] = leftDiag[row - 1 + n - col] = false;
			}
		}
		return result;
	}

	static boolean check(int i, int j, int[][] map) {
		for (int k = 0; 0 <= i - k && 0 <= j - k; k++) { // 왼쪽 대각선 확인
			if (map[i - k][j - k] != 0) {
				return true;
			}
		}
		for (int k = 0; 0 <= i - k && j + k < map.length; k++) { // 오른쪽 대각선 확인
			if (map[i - k][j + k] != 0) {
				return true;
			}
		}
		return false;
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

package 프로그래머스.Lv2;

import java.util.Arrays;

public class 행렬테두리회전하기 {
	static int[] di = { 1, 0, -1, 0 }, dj = { 0, 1, 0, -1 }; // 하우상좌 (시계방향으로 회전해야하니까 반시계방향으로 이동)
//	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 우하좌상 (시계방향)

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	static public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows + 1][columns + 1]; // 행렬
		for (int i = 1; i <= rows; i++) { // 행렬 초기화
			for (int j = 1; j <= columns; j++) {
				map[i][j] = (i - 1) * columns + j;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0], y = queries[i][1], d = 0; // 현재 좌표, 방향
			int ni = x + di[d], nj = y + dj[d]; // 다음 좌표
			int temp = map[x][y], min = map[x][y];
			while (ni != queries[i][0] || nj != queries[i][1]) { // 다음 좌표가 처음 좌표에 도달하기 전까지
				if (queries[i][0] <= ni && ni <= queries[i][2] && queries[i][1] <= nj && nj <= queries[i][3]) {
					// 범위 확인
					map[x][y] = map[ni][nj]; // 현재 좌표에 다음 좌표값 삽입
					min = Math.min(min, map[ni][nj]); // 최솟값 갱신
					// 현재 좌표 이동
					x = ni;
					y = nj;
				} else {
					d = (d + 1) % di.length; // 범위를 벗어나면 방향 전환
				}
				// 다음 좌표 계산
				ni = x + di[d];
				nj = y + dj[d];
			}
			map[x][y] = temp; // 마지막 좌표에 처음 좌표의 값 삽입
			answer[i] = min;
		}
		return answer;
	}

	static public int[] solution2(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows + 1][columns + 1]; // 행렬
		for (int i = 1; i <= rows; i++) { // 행렬 초기화
			for (int j = 1; j <= columns; j++) {
				map[i][j] = (i - 1) * columns + j;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0], y = queries[i][1], d = 0; // 현재 좌표, 방향
			int temp = map[x][y], min = map[x][y];
			while (true) { // 다음 좌표가 처음 좌표에 도달하기 전까지
				int ni = x + di[d], nj = y + dj[d]; // 다음 좌표
				if (ni < queries[i][0] || queries[i][2] < ni || nj < queries[i][1] || queries[i][3] < nj) {
					d = (d + 1) % di.length; // 범위를 벗어나면 방향 전환
					ni = x + di[d];
					nj = y + dj[d];
				}
				int next = map[ni][nj]; // 좌표 회전
				map[ni][nj] = temp;
				temp = next;
				min = Math.min(min, map[ni][nj]); // 최솟값 갱신
				if (ni == queries[i][0] && nj == queries[i][1]) {
					break;
				}
				// 현재 좌표 이동
				x = ni;
				y = nj;
			}
			answer[i] = min;
		}
		return answer;
	}
}

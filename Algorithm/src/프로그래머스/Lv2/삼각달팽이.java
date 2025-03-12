package 프로그래머스.Lv2;

import java.util.Arrays;

public class 삼각달팽이 {
	static int[] di = { 1, 0, -1 }, dj = { 0, 1, -1 }; // 이동하는 방향
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(Arrays.toString(solution(n)));
	}

	static public int[] solution(int n) {
		int[] answer = new int[n * (n + 1) / 2];
		int[][] array = new int[n][n];
		array[0][0] = 1;
		for (int num = 2, x = 0, y = 0, d = 0; num <= answer.length;) {
			int ni = x + di[d]; // 다음으로 이동할 행 위치
			int nj = y + dj[d]; // 다음으로 이동할 열 위치
			if (0 <= ni && ni < n && 0 <= ni && nj < n && array[ni][nj] == 0) { // 범위와 빈공간 확인
				array[ni][nj] = num;
				num += 1;
				x = ni;
				y = nj;
			} else { // 범위를 벗어나거나 이미 채워진 공간이면 방향 전환
				d = (d + 1) % di.length;
			}
		}
		for (int i = 0, idx = 0; i < n; i++) { // 1차원배열로 변경
			for (int j = 0; j <= i; j++) {
				answer[idx++] = array[i][j];
			}
		}
		return answer;
	}
}

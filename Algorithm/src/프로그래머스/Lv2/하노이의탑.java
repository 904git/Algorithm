package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
	static List<int[]> step;

	public static void main(String[] args) {
		int n = 2;
		int[][] result = solution(n);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static public int[][] solution(int n) {
		int[][] answer = {};
		step = new ArrayList<>();
		hanoi(n, 1, 3); // 하노이의 탑
		answer = new int[step.size()][2];
		for (int i = 0; i < step.size(); i++) {
			answer[i] = step.get(i);
		}
		return answer;
	}

	static public void hanoi(int n, int start, int end) { // 하노이의 탑
		if (n == 0) {
			return;
		}
		int next = (start + end) % 4 == 0 ? 2 : (start + end) % 4; // 내 이전 번호가 움직여야 할 위치(start, end가 아닌 곳)
		hanoi(n - 1, start, next); // 이전 번호 이동
		step.add(new int[] { start, end }); // 나 이동
		hanoi(n - 1, next, end); // 이전 번호 이동
	}
}

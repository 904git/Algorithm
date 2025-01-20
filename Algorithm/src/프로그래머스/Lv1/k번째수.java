package 프로그래머스.Lv1;

import java.util.Arrays;

public class k번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	static public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1]; // 자른 배열
			for (int j = commands[i][0] - 1, idx = 0; j <= commands[i][1] - 1; j++) {
				temp[idx++] = array[j];
			}
			Arrays.sort(temp); // 오른차순 정렬
			answer[i] = temp[commands[i][2] - 1]; // k번째 수
		}
		return answer;
	}
}

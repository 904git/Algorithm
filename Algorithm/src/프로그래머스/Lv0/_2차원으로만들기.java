package 프로그래머스.Lv0;

public class _2차원으로만들기 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = 2;
		arrayPrint(solution(num_list, n));
	}

	static public int[][] solution(int[] num_list, int n) {
		int[][] answer = new int[num_list.length / n][n];
		for (int i = 0; i < num_list.length / n; i++) {
			for (int j = 0; j < n; j++) {
				answer[i][j] = num_list[i * n + j];
			}
		}
		return answer;
	}

	static public void arrayPrint(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}

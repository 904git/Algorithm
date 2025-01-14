package 프로그래머스.Lv0;

public class 정사각형으로만들기 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		printArray(solution(arr));
	}

	static public int[][] solution(int[][] arr) {
		int size = Math.max(arr.length, arr[0].length);
		int[][] answer = new int[size][size];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				answer[i][j] = arr[i][j];
			}
		}
		return answer;
	}

	static public void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

package 프로그래머스.Lv1;

public class 행렬의덧셈 {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2 }, { 2, 3 } };
		int[][] arr2 = { { 3, 4 }, { 5, 6 } };
		printArrays(solution(arr1, arr2));
	}

	static public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}

	static public void printArrays(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package 프로그래머스.Lv2;

public class 행렬의곱셈 {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };
		printArray(solution(arr1, arr2));
	}

	static public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) { // arr1의 행
			for (int j = 0; j < answer[0].length; j++) { // arr2의 열
				for (int k = 0; k < arr2.length; k++) { // arr1의 열, arr2의 행
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
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

package 프로그래머스.Lv0;

public class 특별한이차원배열1 {
	public static void main(String[] args) {
		int n = 3;
		ArrayPrint(solution(n));
	}

	static public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		for (int i = 0; i < n; i++) {
			answer[i][i] = 1;
		}
		return answer;
	}

	static public void ArrayPrint(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

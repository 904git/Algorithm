package 프로그래머스.Lv0;

public class 특별한이차원배열2 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 192, 33 }, { 192, 72, 95 }, { 33, 95, 999 } };
		System.out.println(solution(arr));
	}

	static public int solution(int[][] arr) {
		int answer = 1;
		for (int i = 0; i < arr.length && answer != 0; i++) {
			for (int j = i; j < arr.length; j++) { // 대각선으로 반만 확인
				if (arr[i][j] != arr[j][i]) {
					answer = 0;
					break;
				}
			}
		}
		return answer;
	}
}

package 프로그래머스.Lv2;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		compression(0, 0, arr.length, arr, answer); // 압축
		return answer;
	}

	static public void compression(int i, int j, int n, int[][] arr, int[] answer) {
		int data = arr[i][j]; // 압축 시작위치의 값
		boolean isPossible = true;
		for (int ni = i; ni < i + n && isPossible; ni++) { // 길이 n만큼 압축 시작
			for (int nj = j; nj < j + n; nj++) {
				if (data != arr[ni][nj]) { // 다른 값이 있으면 압축 실패
					isPossible = false;
					break;
				}
			}
		}
		if (isPossible) { // 압축 성공
			answer[data] += 1;
		} else { // 압축 실패시 반으로 쪼개서 압축
			compression(i, j, n / 2, arr, answer);
			compression(i + n / 2, j, n / 2, arr, answer);
			compression(i, j + n / 2, n / 2, arr, answer);
			compression(i + n / 2, j + n / 2, n / 2, arr, answer);
		}
	}
}

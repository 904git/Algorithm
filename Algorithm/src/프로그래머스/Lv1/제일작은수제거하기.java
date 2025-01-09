package 프로그래머스.Lv1;

import java.util.Arrays;

public class 제일작은수제거하기 {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		int minIdx = -1;
		for (int i = 0, min = Integer.MAX_VALUE; i < arr.length; i++) { // 최솟값 인덱스 찾기
			if (arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
		}
		int[] answer = { -1 };
		if (arr.length > 1) { // arr의 길이가 1이면 결과가 빈 배열이 되므로 길이가 1보다 큰 것만 처리
			answer = new int[arr.length - 1];
			for (int i = 0, idx = 0; i < arr.length; i++) {
				if (i != minIdx) { // 최소값이 아닌 것만 삽입
					answer[idx++] = arr[i];
				}
			}
		}
		return answer;
	}
}

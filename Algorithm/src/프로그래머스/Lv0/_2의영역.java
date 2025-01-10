package 프로그래머스.Lv0;

import java.util.Arrays;

public class _2의영역 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 4, 5, 2, 9 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		int[] answer = { -1 }; // 2가 없으면 -1 반환
		int start = -1, end = -1; // 2가 위치하는 인덱스
		for (int i = 0; i < arr.length && (start < 0 || end < 0); i++) {
			if (start < 0 && arr[i] == 2) { // 2가 처음 나온 위치
				start = i;
			}
			if (end < 0 && arr[arr.length - 1 - i] == 2) { // 2가 마지막에 나온 위치
				end = arr.length - 1 - i;
			}
		}
		if (0 <= start && 0 <= end) { // 2가 존재하면
			answer = new int[end - start + 1];
			for (int i = start, idx = 0; i <= end; i++) {
				answer[idx++] = arr[i];
			}
		}
		return answer;
	}
}

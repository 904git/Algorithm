package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열의원소만큼추가하기 {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4 };
		System.out.println(Arrays.toString(solution(arr)));
	}

	static public int[] solution(int[] arr) {
		int size = 0; // answer의 총 길이
		for (int i = 0; i < arr.length; i++) {
			size += arr[i];
		}
		int[] answer = new int[size];
		for (int i = 0, idx = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) { // arr[i]를 arr[i]번 배열에 삽입
				answer[idx++] = arr[i];
			}
		}
		return answer;
	}
}

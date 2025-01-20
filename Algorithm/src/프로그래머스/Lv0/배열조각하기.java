package 프로그래머스.Lv0;

import java.util.Arrays;

public class 배열조각하기 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		int[] query = { 4, 1, 2 };
		System.out.println(Arrays.toString(solution(arr, query)));
	}

	static public int[] solution(int[] arr, int[] query) {
		int[] answer = Arrays.copyOfRange(arr, 0, arr.length);
		for (int i = 0; i < query.length; i++) {
			if (i % 2 == 0) { // 짝수 인덱스
				answer = Arrays.copyOfRange(answer, 0, query[i] + 1); // 뒷부분 날리기
			} else { // 홀수 인덱스
				answer = Arrays.copyOfRange(answer, query[i], answer.length); // 앞부분 날리기
			}
		}
		return answer;
	}
}

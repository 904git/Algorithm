package 프로그래머스.Lv0;

import java.util.Arrays;

public class 중앙값구하기 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 7, 10, 11 };
		System.out.println(solution(array));
	}

	static public int solution(int[] array) {
		int answer = 0;
		Arrays.sort(array); // 정렬
		answer = array[array.length / 2]; // 정렬한 배열의 중앙값
		return answer;
	}

}

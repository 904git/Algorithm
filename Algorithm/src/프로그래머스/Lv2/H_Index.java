package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		// 6 5 3 1 0
		System.out.println(solution(citations));
	}

	static public int solution(int[] citations) {
		int answer = 0;
		Integer[] number = new Integer[citations.length];
		for (int i = 0; i < citations.length; i++) {
			number[i] = citations[i];
		}
		Arrays.sort(number, Collections.reverseOrder()); // 내림차순 정렬
		for (int i = 0, num = number[0]; i < number.length; i++) {
			if (num != number[i]) { // number[i - 1]이 h-index인지 확인
				if (number[i - 1] <= i && number.length - i <= number[i - 1]) {// i는 number[i - 1]번 이상 인용된 횟수
					answer = number[i - 1];
					break;
				}
			}
		}
		return answer;
	}
}
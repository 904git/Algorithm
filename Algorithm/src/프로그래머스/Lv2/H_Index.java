package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	static public int solution(int[] citations) {
		int answer = citations.length; // n편이 모두 n번 이상 인용
		Integer[] number = new Integer[citations.length];
		for (int i = 0; i < citations.length; i++) {
			number[i] = citations[i];
		}
		Arrays.sort(number, Collections.reverseOrder()); // 내림차순 정렬
		for (int i = 1; i <= number.length; i++) {
			if (i <= number[i - 1]) {
				continue;
			} else {
				answer = i - 1; // number[i-1]이 i 위치보다 크거나 같은 마지막 위치
				break;
			}
		}
		return answer;
	}
}
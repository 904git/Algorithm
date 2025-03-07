package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	static public String solution(int[] numbers) {
		String answer = "";
		String[] str_num = new String[numbers.length]; // 숫자를 문자열로 변경해서 저장
		for (int i = 0; i < numbers.length; i++) {
			str_num[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(str_num, new MySort()); // 정렬
		answer = String.join("", str_num); // 문자열 이어붙이기
		if (answer.charAt(0) == '0') { // 0만 있는 경우 처리
			answer = "0";
		}
		return answer;
	}

	static class MySort implements Comparator<String> { // 두 수를 이어붙였을 때 더 큰 순서대로 정렬

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
		}

	}
}

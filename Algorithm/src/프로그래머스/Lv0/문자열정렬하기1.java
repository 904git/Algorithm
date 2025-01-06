package 프로그래머스.Lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열정렬하기1 {
	public static void main(String[] args) {
		String my_string = "hi12392";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	static public int[] solution(String my_string) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < my_string.length(); i++) {
			if (Character.isDigit(my_string.charAt(i))) { // i번째 문자가 숫자이면
				list.add(Character.getNumericValue(my_string.charAt(i))); // list에 삽입
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer); // 배열 정렬
		return answer;
	}
}

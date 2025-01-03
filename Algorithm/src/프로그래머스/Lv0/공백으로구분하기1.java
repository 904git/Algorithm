package 프로그래머스.Lv0;

import java.util.Arrays;

public class 공백으로구분하기1 {
	public static void main(String[] args) {
		String my_string = "i lobe you";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	static public String[] solution(String my_string) {
		String[] answer = my_string.split(" "); // 공백으로 문자열 나눔
		return answer;
	}

}

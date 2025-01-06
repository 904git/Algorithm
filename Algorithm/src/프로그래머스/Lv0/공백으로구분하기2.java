package 프로그래머스.Lv0;

import java.util.Arrays;

public class 공백으로구분하기2 {
	public static void main(String[] args) {
		String my_string = " i    love  you";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	static public String[] solution(String my_string) {
		my_string = my_string.trim().replaceAll("[ ]+", " "); // 문자열의 양 옆 공백 제거 후 연속된 띄어쓰기를 하나로 변경
		String[] answer = my_string.split(" ");
		return answer;
	}
}

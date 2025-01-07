package 프로그래머스.Lv0;

import java.util.Arrays;

public class 문자열정렬하기2 {
	public static void main(String[] args) {
		String my_string = "Bcad";
		System.out.println(solution(my_string));
	}

	static public String solution(String my_string) {
		String answer = "";
		String[] str_split = my_string.toLowerCase().split("");
		Arrays.sort(str_split); // 정렬
		answer = String.join("", str_split);
		return answer;
	}
}

package 프로그래머스.Lv0;

public class 특정문자제거하기 {
	public static void main(String[] args) {
		String my_string = "abcdef";
		String letter = "f";
		System.out.println(solution(my_string, letter));
	}

	static public String solution(String my_string, String letter) {
		String answer = my_string.replaceAll(letter, "");
		return answer;
	}
}

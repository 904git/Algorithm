package 프로그래머스.Lv0;

public class 숨어있는숫자의덧셈2 {
	public static void main(String[] args) {
		String my_string = "aAb1B2cC34oOp";
		System.out.println(solution(my_string));
	}

	static public int solution(String my_string) {
		int answer = 0;
		String[] str_split = my_string.split("[a-zA-z]+"); // 연속된 알파벳문자로 분할
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].length() > 0) { // 공백 빼고 숫자만
				answer += Integer.parseInt(str_split[i]);
			}
		}
		return answer;
	}
}

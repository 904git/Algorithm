package 프로그래머스.Lv0;

public class 숨어있는숫자의덧셈1 {
	public static void main(String[] args) {
		String my_string = "aAb1B2cC34oOp";
		System.out.println(solution(my_string));
	}

	static public int solution(String my_string) {
		int answer = 0;
		for (int i = 0; i < my_string.length(); i++) {
			if ('0' <= my_string.charAt(i) && my_string.charAt(i) <= '9') { // i번째 문자가 숫자이면 더하기
				answer += my_string.charAt(i) - '0';
			}
		}
		return answer;
	}
}

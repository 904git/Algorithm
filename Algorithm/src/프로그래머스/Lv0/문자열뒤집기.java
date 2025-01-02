package 프로그래머스.Lv0;

public class 문자열뒤집기 {
	public static void main(String[] args) {
		String my_string = "jaron";
		System.out.println(solution(my_string));
	}

	static public String solution(String my_string) {
		String answer = "";
		StringBuffer sb = new StringBuffer(my_string);
		answer = sb.reverse().toString(); // StringBuffer의 reverse 함수 사용
		return answer;
	}

}

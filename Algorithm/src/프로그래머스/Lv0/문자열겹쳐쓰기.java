package 프로그래머스.Lv0;

public class 문자열겹쳐쓰기 {
	public static void main(String[] args) {
		String my_string = "He11oWor1d";
		String overwrite_string = "lloWor";
		int s = 2;
		System.out.println(solution(my_string, overwrite_string, s));
	}

	static public String solution(String my_string, String overwrite_string, int s) {
		String answer = "";
		answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());
		return answer;
	}
}
